package net.lz1998.pbbot.helper;

import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.helper.entity.LuminaMessage;
import net.lz1998.pbbot.utils.Msg;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;

public class LuminaPluginHelper {

    public void sendBasicMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, LuminaMessage luminaMessage) {

        //  获取群号
        System.out.println("[AI-LM][UserID/用户QQ号] " + event.getUserId());
        System.out.println("[AI-LM][GroupID/QQ群号] " + event.getGroupId());
        System.out.println("[AI-LM][RawMessage/原始消息] " + event.getRawMessage());
        //  装箱操作
        Long userIdBox = event.getUserId();
        Long groupIdBox = event.getGroupId();

        //  判断1 关键字全字匹配吗？

        //  判断2 是否针对At进行匹配？

        //  判断3 回复还是新消息

        //  判断4

    }

//    public void sendBasicMessageRespAt(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, LuminaMessage luminaMessage) {
//
//        //  获取群号
//        System.out.println("[AI-LM][UserID/用户QQ号] " + event.getUserId());
//        System.out.println("[AI-LM][GroupID/QQ群号] " + event.getGroupId());
//        System.out.println("[AI-LM][RawMessage/原始消息] " + event.getRawMessage());
//        //  装箱操作
//        Long userIdBox = event.getUserId();
//        Long groupIdBox = event.getGroupId();
////        //  构建消息
////        Msg msg_hello = Msg.builder()
////                .text("露米娜应答测试： \n")
////                .at(event.getUserId()).text(" 你好，我是露米娜-心音！")
////                .image("https://i.loli.net/2021/08/30/6Jf1RWQVBaCDmS3.png");
//    }

}
