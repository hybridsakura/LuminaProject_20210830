package net.lz1998.pbbot.plugin;

import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import net.lz1998.pbbot.utils.Msg;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class DemoPlugin extends BotPlugin {

    @Override
    public int onPrivateMessage(@NotNull Bot bot, @NotNull OnebotEvent.PrivateMessageEvent event) {
        long userId = event.getUserId();
        Msg msg = Msg.builder()
                .face(1)
                .text("你好，我是露米娜，目前正在进行测试\n")
                .text("如有冒犯还请谅解，本消息由IDEA中的运行的QQBOT程序自动发出")
                .image("https://i.loli.net/2021/08/30/6Jf1RWQVBaCDmS3.png");
        bot.sendPrivateMsg(userId, msg, false);

        return MESSAGE_BLOCK;
    }
}
