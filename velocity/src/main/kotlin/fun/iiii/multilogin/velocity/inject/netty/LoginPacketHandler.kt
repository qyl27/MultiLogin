package `fun`.iiii.multilogin.velocity.inject.netty

import com.velocitypowered.proxy.connection.MinecraftConnection
import com.velocitypowered.proxy.protocol.StateRegistry
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import moe.caa.multilogin.api.logger.info

class LoginPacketHandler(val connection: MinecraftConnection) : ChannelInboundHandlerAdapter() {
    override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
        if (connection.state == StateRegistry.LOGIN) {
            // 处理协议加密包
        } else if (connection.state == StateRegistry.PLAY && msg is ByteBuf) {
            // 处理聊天签名
            // 过滤 PlayerSessionPacket 包, 这个包没有注册, 只能读原始 ByteBuf 进行读取
        }
        // 既然都挂载到 Channel 上了, 这里面也许可以塞点可以存下来的数据
        info(msg.javaClass.simpleName)
        ctx.fireChannelRead(msg)
    }
}