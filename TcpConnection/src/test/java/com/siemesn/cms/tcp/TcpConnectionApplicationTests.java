package com.siemesn.cms.tcp;

import com.siemesn.cms.tcp.netty.ChannelRepository;
import com.siemesn.cms.tcp.netty.handler.SomethingChannelInitializer;
import com.siemesn.cms.tcp.netty.handler.SomethingServerHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.junit.Before;
import org.junit.Test;

import java.net.SocketAddress;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TcpConnectionApplicationTests {

	private SomethingServerHandler somethingServerHandler;
	private ChannelHandlerContext channelHandlerContext;
	private Channel channel;
	private SocketAddress remoteAddress;

	@Before
	public void setUp() throws Exception{
		somethingServerHandler = new SomethingServerHandler();
		somethingServerHandler.setChannelRepository(new ChannelRepository());

		channelHandlerContext = mock(ChannelHandlerContext.class);
		channel = mock(Channel.class);
		remoteAddress = mock(SocketAddress.class);
	}

	public void tearDown() throws Exception{

	}

	@Test
	public void testChannelActive() throws  Exception{
		when(channelHandlerContext.channel()).thenReturn(channel);
		when(channelHandlerContext.channel().remoteAddress()).thenReturn(remoteAddress);
		somethingServerHandler.channelActive(channelHandlerContext);
	}

	@Test
	public void testChannelRead() throws Exception {
		when(channelHandlerContext.channel()).thenReturn(channel);
		somethingServerHandler.channelRead(channelHandlerContext, "test message");
	}

	@Test
	public void testExceptionCaught() throws Exception {

	}
}
