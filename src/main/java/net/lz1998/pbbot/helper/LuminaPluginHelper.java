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


        //  对消息中是否包含at露米娜的内容进行侦测
        luminaRequireSetup = luminaPrebuild.setLuminaAtRule(luminaRequireSetup, event.getRawMessage());

        //  消息状况报告
        System.out.println("=============================");
        System.out.println("是否要求 检测艾特露米娜：" + (luminaRequireSetup.isRequireAtLumina() ? "是":"否"));
        System.out.println("侦测到的信息 是否艾特了露米娜：" + (luminaRequireSetup.isDetectAtLumina() ? "是":"否"));
        System.out.println("侦测到的信息 要求匹配内容:" + ("".equals(luminaRequireSetup.getMessageDetected()) ? "（空字符串）" : luminaRequireSetup.getMessageDetected()));
        System.out.println("侦测到的信息 全字匹配要求：" + (luminaRequireSetup.isMessageDetected_requireEquals() ? "是":"否"));
        System.out.println("回复时 使用回复框回复对话：" + (luminaRequireSetup.isRequireRespReply() ? "是":"否"));
        System.out.println("回复时 对对方进行艾特操作：" + (luminaRequireSetup.isRequireRespAt() ? "是":"否"));
        System.out.println("=============================");

        boolean atDetectAndRequire = luminaRequireSetup.isRequireAtLumina() && luminaRequireSetup.isDetectAtLumina();
        boolean atNotDetect = !luminaRequireSetup.isDetectAtLumina();

        Msg msg_running;
        if(luminaRequireSetup.isRequireRespReply() && atDetectAndRequire) {
            msg_running = Msg.builder()
                    .reply(event.getMessageId())
                    .text(luminaRequireSetup.getMessageResponse());
            bot.sendGroupMsg(event.getGroupId(), msg_running, false);
        } else if(!luminaRequireSetup.isRequireRespReply() && atDetectAndRequire){
            msg_running = Msg.builder()
                    .at(event.getUserId())
                    .text(luminaRequireSetup.getMessageResponse());
            bot.sendGroupMsg(event.getGroupId(), msg_running, false);
        }
    }

    public void sendBundleMessageWithAt() {

    }



}
