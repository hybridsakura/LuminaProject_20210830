package net.lz1998.pbbot.plugin;

import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import net.lz1998.pbbot.utils.Msg;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

@Component
public class MiyakoPlugin extends BotPlugin {

    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event) {

        //  获取群号
        long userId = event.getUserId();
        long groupId = event.getGroupId();
        String rawMessage = event.getRawMessage();
        System.out.println("[AI-LM][UserID/用户QQ号] " + userId);
        System.out.println("[AI-LM][GroupID/QQ群号] " + groupId);
        System.out.println("[AI-LM][RawMessage/原始消息] " + rawMessage);

        //  装箱操作
        Long userIdBox = userId;
        Long groupIdBox = groupId;

        //  构建消息
        Msg msg1 = Msg.builder()
                .text("露米娜应答测试： \n")
                .at(userId).text(" 你好，我是露米娜-心音！")
                .image("https://i.loli.net/2021/08/30/6Jf1RWQVBaCDmS3.png");
        Msg msgLevel_0 = Msg.builder()
                .text("[msgLevel_0]= \n")
                .text("抽中了大吉！");
        Msg msgLevel_1 = Msg.builder()
                .text("[msgLevel_1]= \n")
                .text("抽中了中吉！");
        Msg msgLevel_2 = Msg.builder()
                .text("[msgLevel_2]= \n")
                .text("抽中了末吉！");
        Msg msgLevel_3 = Msg.builder()
                .text("[msgLevel_3]= \n")
                .text("抽中了凶！摸摸头~");
        Msg msgLevel_4 = Msg.builder()
                .text("[msgLevel_4]= \n")
                .text("抽中了大凶！呜哇！喵都发火了！");

        //  构建判断标识
        boolean atLumina_raw = rawMessage.contains("<at qq=\"2792556795\"/>");
        boolean atLumina_miyako = rawMessage.contains("@女神转生的喵都厨");
        boolean atLumina_lm = rawMessage.contains("@lumina");
        boolean findStringGacha = rawMessage.contains("抽签");

        Random r = new Random(new Date().getTime());
        int ran = r.nextInt(100);
        //  随机化

        boolean inRangeA = ran >= 95;
        boolean inRangeB = ran < 95 && ran >= 85;
        boolean inRangeC = ran < 85 && ran >= 65;
        boolean inRangeD = ran < 65 && ran >= 40;
        boolean inRangeE = ran < 40;


        //  构建消息并发出
        if (rawMessage.contains("心音妹妹")) {
            bot.sendGroupMsg(groupId, msg1, false);
        } else if((atLumina_raw || atLumina_miyako || atLumina_lm) && inRangeA) {
            bot.sendGroupMsg(groupId, msgLevel_0, false);
        } else if((atLumina_raw || atLumina_miyako || atLumina_lm) && inRangeB) {
            bot.sendGroupMsg(groupId, msgLevel_1, false);
        } else if((atLumina_raw || atLumina_miyako || atLumina_lm) && inRangeC) {
            bot.sendGroupMsg(groupId, msgLevel_2, false);
        } else if((atLumina_raw || atLumina_miyako || atLumina_lm) && inRangeD) {
            bot.sendGroupMsg(groupId, msgLevel_3, false);
        } else if(atLumina_raw || atLumina_miyako || atLumina_lm) {
            bot.sendGroupMsg(groupId, msgLevel_4, false);
        }

//        else if((atLumina_raw || atLumina_miyako) && findStringGacha && userIdBox == 179223207) {
//            bot.sendGroupMsg(groupId, msgLevel_4, false);
//        }else if((atLumina_raw || atLumina_miyako) && findStringGacha) {
//            bot.sendGroupMsg(groupId, msgLevel_0, false);
//        }

        return MESSAGE_BLOCK;
    }
}
