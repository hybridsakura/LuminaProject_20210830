package net.lz1998.pbbot.helper;

import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.helper.entity.LuminaRequireSetup;
import net.lz1998.pbbot.utils.Msg;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;

public class LuminaPluginHelper {

    LuminaPrebuild luminaPrebuild = new LuminaPrebuild();

    public void sendBasicMessageWithAt(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, LuminaRequireSetup luminaRequireSetup) {

        //  获取群号
        System.out.println("2[AI-LM][UserID/用户QQ号] " + event.getUserId());
        System.out.println("2[AI-LM][GroupID/QQ群号] " + event.getGroupId());
        System.out.println("2[AI-LM][RawMessage/原始消息] " + event.getRawMessage());
        //  装箱操作
        Long userIdBox = event.getUserId();
        Long groupIdBox = event.getGroupId();

//        luminaRequireSetup = luminaPrebuild.setLuminaAtRule(luminaRequireSetup, event.getRawMessage());

        Msg msg_running;
        LuminaRequireSetup tempSetup = luminaPrebuild.setLuminaAtRule(luminaRequireSetup, event.getRawMessage());

        System.out.println("=============================");
        System.out.println("侦测到的信息 是否艾特了露米娜：" + (tempSetup.isRequireAtLumina() ? "是":"否"));
        System.out.println("侦测到的信息 要求匹配内容:" + ("".equals(tempSetup.getMessageDetected()) ? "（空字符串）" : tempSetup.getMessageDetected()));
        System.out.println("侦测到的信息 全字匹配要求：" + (tempSetup.isMessageDetected_requireEquals() ? "是":"否"));
        System.out.println("回复时 使用回复框回复对话：" + (tempSetup.isRequireRespReply() ? "是":"否"));
        System.out.println("回复时 对对方进行艾特操作：" + (tempSetup.isRequireRespAt() ? "是":"否"));
        System.out.println("=============================");

        if(tempSetup.isRequireRespReply() && tempSetup.isRequireAtLumina()) {
            msg_running = Msg.builder()
                    .reply(event.getMessageId())
                    .text(tempSetup.getMessageResponse());
            bot.sendGroupMsg(event.getGroupId(), msg_running, false);
        } else if(!tempSetup.isRequireRespReply() && tempSetup.isRequireAtLumina()){
            msg_running = Msg.builder()
                    .at(event.getUserId())
                    .text(tempSetup.getMessageResponse());
            bot.sendGroupMsg(event.getGroupId(), msg_running, false);
        }




        System.out.println("test test");



    }


}
