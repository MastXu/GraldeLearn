package com.learn.netty.Services;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Author : mastXu
 * Description : saying something
 * Date : 2017/10/9.
 * Modify :
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        try {
            // Do something with msg
            //打印出来
            System.out.println(in.toString(io.netty.util.CharsetUtil.US_ASCII));
            //输出到客户端
            ctx.writeAndFlush(msg);
        } finally {
//            ReferenceCountUtil.release(msg); //在这里调用 in.release() 替换
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { //
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }

}
