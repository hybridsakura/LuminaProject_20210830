package net.lz1998.pbbot.plugin;

import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import net.lz1998.pbbot.helper.LuminaPluginHelper;
import net.lz1998.pbbot.helper.LuminaPrebuild;
import net.lz1998.pbbot.helper.entity.LuminaRequireSetup;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class LuminaGroupPlugin extends BotPlugin {

    LuminaPluginHelper pluginHelper = new LuminaPluginHelper();
    LuminaPrebuild luminaPrebuild = new LuminaPrebuild();

    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event) {


        boolean needAtLumina = true;


        //  1.针对所有@lumina的消息进行回复，并复述内容。
        LuminaRequireSetup lumina_EmptyMessageWithAt = new LuminaRequireSetup();            //  [必须，否则就会变成全回复]是否需要艾特露米娜

        lumina_EmptyMessageWithAt.setMessageDetected("");                                   //  检测文本回应(全匹配)

        //  回复时需要检测艾特露米娜吗？
        lumina_EmptyMessageWithAt.setRequireAtLumina(false);


        //  设定检测模式
//        if() {
////            lumina_EmptyMessageWithAt = luminaPrebuild.setLuminaAtRule(lumina_EmptyMessageWithAt, event.getRawMessage());
//        }else {
//            lumina_EmptyMessageWithAt.setRequireAtLumina(false);
//        }

        lumina_EmptyMessageWithAt.setMessageResponse("咱是心音，目前已经进入露米娜集成（AI）模式。（程序已处于运行中）");
        lumina_EmptyMessageWithAt.setMessageDetected_requireEquals(false);                  //  不要求全字匹配

        lumina_EmptyMessageWithAt.setRequireRespAt(true);                                   //  是否需要进行at对方
        lumina_EmptyMessageWithAt.setRequireRespReply(false);                               //  可以不写




        pluginHelper.sendBasicMessageWithAt(bot, event, lumina_EmptyMessageWithAt);


        return MESSAGE_BLOCK;
    }



}
