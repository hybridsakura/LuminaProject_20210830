package net.lz1998.pbbot.plugin;

import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import net.lz1998.pbbot.helper.LuminaPluginHelper;
import net.lz1998.pbbot.helper.LuminaPrebuild;
import net.lz1998.pbbot.helper.entity.LuminaRequireSetup;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LuminaGroupPlugin extends BotPlugin {

    LuminaPluginHelper pluginHelper = new LuminaPluginHelper();
    LuminaPrebuild luminaPrebuild = new LuminaPrebuild();

    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event) {

//        //  首次测试部分
//        LuminaRequireSetup lumina_EmptyMessageWithAt = new LuminaRequireSetup();            //  [必须，否则就会变成全回复]是否需要艾特露米娜
//        lumina_EmptyMessageWithAt.setMessageDetected("");                                   //  检测文本回应(全匹配)
//        lumina_EmptyMessageWithAt.setMessageDetected_requireEquals(false);                  //  不要求全字匹配
//        //  回复时需要检测艾特露米娜吗？
//        lumina_EmptyMessageWithAt.setRequireAtLumina(false);
//        lumina_EmptyMessageWithAt.setMessageResponse("咱是心音，目前已经进入露米娜集成（AI）模式。（程序已处于运行中）");
//        lumina_EmptyMessageWithAt.setRequireRespAt(true);                                   //  是否需要进行at对方
//        lumina_EmptyMessageWithAt.setRequireRespReply(false);                               //  可以不写
//        pluginHelper.sendBasicMessageWithAt(bot, event, lumina_EmptyMessageWithAt);


        List<LuminaRequireSetup> requireSetupList = new ArrayList<>();

        LuminaRequireSetup setupSequence1 = new LuminaRequireSetup();
        //  [1]是抽签
        setupSequence1.setMessageDetected("抽签");
        setupSequence1.setMessageDetected_requireEquals(false);
        setupSequence1.setRequireAtLumina(false);
        setupSequence1.setMessageResponse("[1]是抽签 （此处文字不会被处理）");
        setupSequence1.setRequireRespAt(false);

        System.out.println("RequireAtLumina:" + setupSequence1.isRequireAtLumina());

        LuminaRequireSetup setupSequence2 = new LuminaRequireSetup();


        LuminaRequireSetup setupSequence3 = new LuminaRequireSetup();


        LuminaRequireSetup setupSequence4 = new LuminaRequireSetup();


        LuminaRequireSetup setupSequence5 = new LuminaRequireSetup();


        requireSetupList.add(setupSequence1);
        requireSetupList.add(setupSequence2);
        requireSetupList.add(setupSequence3);
        requireSetupList.add(setupSequence4);
        requireSetupList.add(setupSequence5);

        pluginHelper.sendBundleMessageWithAt(bot, event, requireSetupList);

        return MESSAGE_BLOCK;
    }



}
