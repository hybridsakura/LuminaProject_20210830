package net.lz1998.pbbot.helper;

import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.helper.app.LuminaGacha;
import net.lz1998.pbbot.helper.entity.LuminaRequireSetup;
import net.lz1998.pbbot.utils.Msg;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LuminaPluginHelper {

    LuminaPrebuild luminaPrebuild = new LuminaPrebuild();
    LuminaGacha luminaGacha = new LuminaGacha();

    public void sendBasicMessageWithAt(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, LuminaRequireSetup luminaRequireSetup) {

        //  获取群号
        System.out.println("2[AI-LM][UserID/用户QQ号] " + event.getUserId());
        System.out.println("2[AI-LM][GroupID/QQ群号] " + event.getGroupId());
        System.out.println("2[AI-LM][RawMessage/原始消息] " + event.getRawMessage());
        //  装箱操作
//        Long userIdBox = event.getUserId();
//        Long groupIdBox = event.getGroupId();


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

    //  上级函数传入一捆消息，并针对处理
    public void sendBundleMessageWithAt(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, List<LuminaRequireSetup> requireSetupList) {
        //  获取群号
        System.out.println("2[AI-LM][UserID/用户QQ号] " + event.getUserId());
        System.out.println("2[AI-LM][GroupID/QQ群号] " + event.getGroupId());
        System.out.println("2[AI-LM][RawMessage/原始消息] " + event.getRawMessage());

        // [1] 抽签
        //  对消息中是否包含at露米娜的内容进行侦测
        LuminaRequireSetup tempSetup_1 = luminaPrebuild.setLuminaAtRule(requireSetupList.get(0), event.getRawMessage());
        List<String> gachaResultList = luminaGacha.gachaResultGen();
        //  消息状况报告
        System.out.println("=============================");
        System.out.println("是否要求 检测艾特露米娜：" + (tempSetup_1.isRequireAtLumina() ? "是":"否"));
        System.out.println("侦测到的信息 是否艾特了露米娜：" + (tempSetup_1.isDetectAtLumina() ? "是":"否"));
        System.out.println("侦测到的信息 要求匹配内容:" + ("".equals(tempSetup_1.getMessageDetected()) ? "（空字符串）" : tempSetup_1.getMessageDetected()));
        System.out.println("侦测到的信息 全字匹配要求：" + (tempSetup_1.isMessageDetected_requireEquals() ? "是":"否"));
        System.out.println("回复时 使用回复框回复对话：" + (tempSetup_1.isRequireRespReply() ? "是":"否"));
        System.out.println("回复时 对对方进行艾特操作：" + (tempSetup_1.isRequireRespAt() ? "是":"否"));
        System.out.println("=============================");
        boolean atDetectAndRequire = tempSetup_1.isRequireAtLumina() && tempSetup_1.isDetectAtLumina();
        boolean detectKeyword = event.getRawMessage().contains(tempSetup_1.getMessageDetected());

        Msg msg_running;
        if(tempSetup_1.isRequireRespReply() && detectKeyword) {
            msg_running = Msg.builder()
                    .reply(event.getMessageId())
                    .text(gachaResultList.get(0));
            bot.sendGroupMsg(event.getGroupId(), msg_running, false);
        } else if(!tempSetup_1.isRequireRespReply() && detectKeyword){
            msg_running = Msg.builder()
                    .at(event.getUserId())
                    .text(gachaResultList.get(0));
            bot.sendGroupMsg(event.getGroupId(), msg_running, false);
        }

        // [2]

    }



}
