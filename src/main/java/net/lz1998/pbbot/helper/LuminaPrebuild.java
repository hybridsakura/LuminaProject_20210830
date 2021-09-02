package net.lz1998.pbbot.helper;

import net.lz1998.pbbot.helper.entity.LuminaRequireSetup;

public class LuminaPrebuild {

    public LuminaRequireSetup setLuminaAtRule(LuminaRequireSetup requireSetup, String rawMessage) {

        if(requireSetup != null) {
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

            boolean atKeyword_1_1 = rawMessage.contains("@宫代泉里");
            boolean atKeyword_1_2 = rawMessage.contains("<at qq=\" \"/");
            boolean atKeyword_2_1 = rawMessage.contains("@一直恐惧");
            boolean atKeyword_2_2 = rawMessage.contains("<at qq=\" \"/");
            boolean atKeyword_3_1 = rawMessage.contains("@过往已既");
            boolean atKeyword_3_2 = rawMessage.contains("<at qq=\" \"/");
            boolean atKeyword_4_1 = rawMessage.contains("@萌新");
            boolean atKeyword_4_2 = rawMessage.contains("@公主");
            boolean atKeyword_4_3 = rawMessage.contains("<at qq=\" \"/");
            boolean atKeyword_5_1 = rawMessage.contains("@L'enfer, c'est les autres");
            boolean atKeyword_5_2 = rawMessage.contains("@ずっとこのまま");
            boolean atKeyword_5_3 = rawMessage.contains("<at qq=\" \"/");
            boolean atKeyword = atKeyword_1_1 || atKeyword_1_2 ||
                    atKeyword_2_1 || atKeyword_2_2 ||
                    atKeyword_3_1 || atKeyword_3_2 ||
                    atKeyword_4_1 || atKeyword_4_2 || atKeyword_4_3 ||
                    atKeyword_5_1 || atKeyword_5_2 || atKeyword_5_3;


            boolean atLumina = atLumina_basic || atLumina_miyako || atLumina_lm || atKeyword;

            requireSetup.setDetectAtLumina(atLumina);
            return requireSetup;
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
