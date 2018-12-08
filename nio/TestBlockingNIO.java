package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

public class TestBlockingNIO {

	// 客户端
	@Test
	public void client() throws IOException {
		// 1. 获取通道
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

		FileChannel inChannel = FileChannel.open(Paths.get("./src/nio/1.jpg"), StandardOpenOption.READ);

		// 2. 分配指定大小的缓冲区
		ByteBuffer buf = ByteBuffer.allocate(1024);

		// 3. 读取本地文件，并发送到服务端
		while (inChannel.read(buf) != -1) {
			buf.flip();
			sChannel.write(buf);
			buf.clear();
		}

		// 4. 关闭通道
		sChannel.close();
		inChannel.close();
	}

	@Test
	public void server() throws IOException {
		// 1. 获取通道
		ServerSocketChannel ssc = ServerSocketChannel.open();

		FileChannel outChannel = FileChannel.open(Paths.get("./src/nio/2.jpg"), StandardOpenOption.WRITE,
				StandardOpenOption.CREATE);

		// 2. 绑定连接
		ssc.bind(new InetSocketAddress(9898));

		// 3. 获取客户端连接的通道
		SocketChannel sc = ssc.accept();

		// 4. 分配指定大小的缓冲区
		ByteBuffer buf = ByteBuffer.allocate(1024);

		// 5. 接收客户端的数据，并保存到本地
		while (sc.read(buf) != -1) {
			buf.flip();
			outChannel.write(buf);
			buf.clear();
		}

		// 6. 关闭通道
		outChannel.close();
		ssc.close();
		sc.close();
	}

}
