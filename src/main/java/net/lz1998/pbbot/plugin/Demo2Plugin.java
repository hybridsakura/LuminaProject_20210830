package net.lz1998.pbbot.plugin;

import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import net.lz1998.pbbot.utils.Msg;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class Demo2Plugin extends BotPlugin {

    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event) {
        //  获取群号
        long userId = event.getUserId();
        long groupId = event.getGroupId();
        String rawMessage = event.getRawMessage();
        System.out.println("[AI-LM][RawMessage]="+rawMessage);

        Msg msg1 = Msg.builder()
                .text("露米娜应答测试")
                .image("https://i.loli.net/2021/08/30/6Jf1RWQVBaCDmS3.png");

        Msg msg2 = Msg.builder()
                .text("MSG2: 呜哇，抽到了大胸！（美羽姐姐）");

        Msg msg3 = Msg.builder()
                .text("MSG3: 好耶！抽中了大吉地说！");
//        if ("hello".equals(rawMessage)) {
//            Msg.builder().at(userId).text("hi，").face(1).text("你的QQ是" + userId).sendToGroup(bot, groupId);
//        }

        Long userId_Box = userId;

        if (rawMessage.contains("露米娜酱")) {
            bot.sendGroupMsg(groupId, msg1, false);
        }else if(rawMessage.equals("抽签") && (userId_Box == 179223207 || userId_Box == 1317274709)) {
            bot.sendGroupMsg(groupId, msg2, false);
        }else if(rawMessage.equals("抽签")) {
            bot.sendGroupMsg(groupId, msg3, false);
        }


        return MESSAGE_BLOCK;
    }
}
