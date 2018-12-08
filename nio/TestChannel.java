package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

/*
 * 一、通道（Channel）：用于源节点与目标节点的连接。在 Java NIO 中负责缓冲区中数据的传输。Channel 本身不存储数据，因此需要配合缓冲区进行传输。
 * 
 * 二、通道的主要实现类
 * 	java.nio.channels.Channel 接口：
 * 		|--FileChannel(本地文件传输)
 * 		|--SocketChannel(TCP)
 * 		|--ServerSocketChannel(TCP)
 * 		|--DatagramChannel(UDP)
 * 
 * 三、获取通道
 * 1. Java 针对支持通道的类提供了 getChannel() 方法
 * 		本地 IO：
 * 		FileInputStream/FileOutputStream
 * 		RandomAccessFile
 * 
 * 		网络IO：
 * 		Socket
 * 		ServerSocket
 * 		DatagramSocket
 * 		
 * 2. 在 JDK 1.7 中的 NIO.2 针对各个通道提供了静态方法 open()
 * 3. 在 JDK 1.7 中的 NIO.2 的 Files 工具类的 newByteChannel()
 * 
 * 四、通道之间的数据传输
 * transferFrom()
 * transferTo()
 * 
 * 五、分散(Scatter)与聚集(Gather)
 * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
 * 聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中
 * 
 * 六、字符集：Charset
 * 编码：字符串 -> 字节数组
 * 解码：字节数组  -> 字符串
 */

public class TestChannel {

	// 利用通道完成文件的复制（非直接缓冲区）
	@Test
	public void test1() {
		long start = System.currentTimeMillis();

		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			fis = new FileInputStream("./src/nio/1.jpg");
			fos = new FileOutputStream("./src/nio/2.jpg");

			// ①获取通道
			inChannel = fis.getChannel();
			outChannel = fos.getChannel();

			// ②分配指定大小的缓冲区
			ByteBuffer buf = ByteBuffer.allocate(1024);

			// ③将通道中的数据存入缓冲区中
			while (inChannel.read(buf) != -1) {
				buf.flip(); // 切换读取数据的模式
				// ④将缓冲区中的数据写入通道中
				outChannel.write(buf);
				buf.clear();// 清空缓冲区
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inChannel != null) {
				try {
					inChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outChannel != null) {
				try {
					outChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("耗费时间为：" + (end - start));
	}

	// 使用直接缓冲区完成文件的复制(内存映射文件)
	@Test
	public void test2() throws IOException {
		long start = System.currentTimeMillis();

		FileChannel inChannel = FileChannel.open(Paths.get("./src/nio/1.jpg"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("./src/nio/3.jpg"), StandardOpenOption.READ,
				StandardOpenOption.WRITE, StandardOpenOption.CREATE);

		// 内存映射文件
		MappedByteBuffer inMap = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
		MappedByteBuffer outMap = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());

		// 直接对缓冲区进行数据的读写操作
		byte[] dst = new byte[inMap.limit()];
		inMap.get(dst);
		outMap.put(dst);

		inChannel.close();
		outChannel.close();

		long end = System.currentTimeMillis();
		System.out.println("耗费时间为：" + (end - start));
	}

	// 通道之间的数据传输(直接缓冲区)
	@Test
	public void test3() throws IOException {
		FileChannel inChannel = FileChannel.open(Paths.get("./src/nio/1.jpg"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("./src/nio/4.jpg"), StandardOpenOption.READ,
				StandardOpenOption.WRITE, StandardOpenOption.CREATE);

		inChannel.transferTo(0, inChannel.size(), outChannel);

		inChannel.close();
		outChannel.close();
	}

	// 分散和聚集
	@Test
	public void test4() throws IOException {
		RandomAccessFile accessFile = new RandomAccessFile("./src/nio/1.txt", "rw");

		// 1. 获取通道
		FileChannel channel1 = accessFile.getChannel();

		// 2. 分配指定大小的缓冲区
		ByteBuffer buf1 = ByteBuffer.allocate(200);
		ByteBuffer buf2 = ByteBuffer.allocate(1024);

		// 3. 分散读取
		ByteBuffer[] dsts = { buf1, buf2 };
		channel1.read(dsts);

		for (ByteBuffer buf : dsts) {
			buf.flip();
		}

		System.out.println(new String(buf1.array(), 0, buf1.limit()));
		System.out.println("--------------------------");
		System.out.println(new String(buf2.array(), 0, buf2.limit()));

		// 4. 聚集写入
		RandomAccessFile accessFile2 = new RandomAccessFile("./src/nio/2.txt", "rw");
		FileChannel channel2 = accessFile2.getChannel();
		channel2.write(dsts);

		accessFile.close();
		accessFile2.close();
		channel1.close();
		channel2.close();
	}

	// 字符集
	@Test
	public void test5() throws IOException {
		Charset charset = Charset.forName("GBK");

		// 获取编码器
		CharsetEncoder ce = charset.newEncoder();
		// 获取解码器
		CharsetDecoder cd = charset.newDecoder();

		CharBuffer cBuf = CharBuffer.allocate(1024);
		cBuf.put("我是刘德华");
		cBuf.flip();

		// 编码
		ByteBuffer bBuf = ce.encode(cBuf);
		for (int i = 0; i < 10; i++) {
			System.out.println(bBuf.get());
		}

		// 解码
		bBuf.flip();
		CharBuffer cBuf2 = cd.decode(bBuf);
		System.out.println(cBuf2.toString());

		System.out.println("------------------------------");
		
		bBuf.flip();
		Charset charset2 = Charset.forName("UTF-8");
		CharBuffer cBuf3 = charset2.decode(bBuf);
		System.out.println(cBuf3.toString());
	}

}
