package net.lz1998.pbbot.helper;

import net.lz1998.pbbot.helper.entity.LuminaMessage;

import java.util.ArrayList;
import java.util.List;

public class LuminaPrebuild {

    public LuminaMessage setLuminaAtRule(LuminaMessage message, String rawMessage) {

        if(message != null) {
            //  指定lumina响应的at名

            boolean atLumina_raw = rawMessage.contains("<at qq=\"2792556795\"/>");
            boolean atLumina_name = rawMessage.contains("@メガミテンセイ");
            boolean atLumina_avatar = rawMessage.contains("@露米娜");
            boolean atLumina_kokone_1 = rawMessage.contains("@心音");
            boolean atLumina_kokone_2 = rawMessage.contains("@心音妹妹");

            boolean atLumina_miyako_1 = rawMessage.contains("@女神转生的喵都厨");
            boolean atLumina_miyako_2 = rawMessage.contains("@喵都厨");

            boolean atLumina_lm_1 = rawMessage.contains("@lumina");
            boolean atLumina_lm_2 = rawMessage.contains("@luminabot");

            boolean atLumina_basic = atLumina_raw || atLumina_name || atLumina_avatar || atLumina_kokone_1 || atLumina_kokone_2;
            boolean atLumina_miyako = atLumina_miyako_1 || atLumina_miyako_2;
            boolean atLumina_lm = atLumina_lm_1 || atLumina_lm_2;

            boolean atLumina = atLumina_basic || atLumina_miyako || atLumina_lm;

            message.setAtLumina(atLumina);
            return message;
        }else {
            System.err.println("setLuminaAtRule传入参数不得为空！");
            return null;
        }

    }

//    public LuminaMessage setLuminaBlacklistRule(LuminaMessage message, List<Long>... blackList) {
//
//        List<Long> defaultBlackQQList = new ArrayList<>();
//        List<Long> defaultBlackQQGroupList = new ArrayList<>();
//
//
//
//
//
//    }

}
