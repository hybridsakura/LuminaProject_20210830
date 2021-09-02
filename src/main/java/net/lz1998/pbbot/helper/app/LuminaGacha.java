package net.lz1998.pbbot.helper.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class LuminaGacha {

    public List<String> gachaResultGen() {

        String backWord = "抽签结果未定义";
        String backImageURL = "/";

        List<String> gachaResultList = new ArrayList<>();

        Random r = new Random(new Date().getTime());
        int ran1 = r.nextInt(1000);
//        int ran2 = r.nextInt(100);

        boolean inRangeA = ran1 >= 800;
        boolean inRangeB = ran1 < 800 && ran1 >= 600;
        boolean inRangeC = ran1 < 600 && ran1 >= 400;
        boolean inRangeD = ran1 < 400 && ran1 >= 200;
        boolean inRangeE = ran1 <= 199 && ran1 > 0;

        if(inRangeA) {
            backWord = " 抽中了大吉！";
            backImageURL = "/1";
        } else if(inRangeB) {
            backWord = " 抽中了中吉！";
            backImageURL = "/2";
        } else if(inRangeC) {
            backWord = " 抽中了木吉！（欸？）";
            backImageURL = "/3";
        } else if(inRangeD) {
            backWord = " 抽中了凶！摸摸头~";
            backImageURL = "/3";
        } else if(inRangeE) {
            backWord = " 抽中了大凶！\n 呜哇！喵都发火了！";
            backImageURL = "/4";
        } else {
            backWord = "你运气真的非常好！出现这种结果的概率是千分之一！\n 作者决定请你喝一瓶可乐，请私信领取！";
            backImageURL = "/5";
        }

        gachaResultList.add(backWord);
        gachaResultList.add(backImageURL);

        return gachaResultList;
    }


}
