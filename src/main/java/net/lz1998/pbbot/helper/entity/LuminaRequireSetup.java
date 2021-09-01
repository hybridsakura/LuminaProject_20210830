package net.lz1998.pbbot.helper.entity;

import java.io.Serializable;
import java.util.List;

public class LuminaRequireSetup implements Serializable {

    private static final long serialVersionUID = 9158483452708692944L;

    private String messageDetected;                             //  消息中侦测到的关键字
    private boolean messageDetected_requireEquals;              //  是否要求[侦测到的关键字]必须全匹配
    private String messageResponse;                             //  进行回应的消息
    private boolean requireAtLumina;                            //  是否针对@(at)进行反应，还是只要侦测到关键字就反应
    private boolean requireRespAt;                              //  回复时是否 @(at) 对方 （和下方冲突）
    private boolean requireRespReply;                           //  回复时是否 对消息进行回复 对方 （和上方冲突）
    private String respMode;                                    //  自动设置项 回复模式
    private List<Long> blackQQUserList;                         //  QQ用户黑名单
    private List<Long> blackQQGroupList;                        //  QQ群黑名单

    public String getMessageDetected() {
        return messageDetected;
    }

    public void setMessageDetected(String messageDetected) {
        this.messageDetected = messageDetected;
    }

    public boolean isMessageDetected_requireEquals() {
        return messageDetected_requireEquals;
    }

    public void setMessageDetected_requireEquals(boolean messageDetected_requireEquals) {
        this.messageDetected_requireEquals = messageDetected_requireEquals;
    }

    public String getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }

    public boolean isRequireAtLumina() {
        return requireAtLumina;
    }

    public void setRequireAtLumina(boolean requireAtLumina) {
        this.requireAtLumina = requireAtLumina;
    }

    public boolean isRequireRespAt() {
        return requireRespAt;
    }

    public void setRequireRespAt(boolean requireRespAt) {
        if("lumina-reply_with_at".equals(this.respMode)) {
            this.requireRespAt = true;
            this.requireRespReply = false;
        }else if("lumina-reply_last_message".equals(this.respMode)) {
            this.requireRespAt = false;
            this.requireRespReply = true;
        }else {
            this.requireRespAt = requireRespAt;
            this.requireRespReply = !this.requireRespAt;
        }
    }

    public boolean isRequireRespReply() {
        return requireRespReply;
    }

    public void setRequireRespReply(boolean requireRespReply) {
        if("lumina-reply_last_message".equals(this.respMode)) {
            this.requireRespReply = true;
            this.requireRespAt = false;
        }else if("lumina-reply_with_at".equals(this.respMode)) {
            this.requireRespReply = false;
            this.requireRespAt = true;
        }else {
            this.requireRespReply = requireRespReply;
            this.requireRespAt = !this.requireRespReply;
        }
    }

    public String getRespMode() {
        return respMode;
    }

//    public void setRespMode(String respMode) {
//        if(this.requireRespAt && !this.requireRespReply) {
//            this.respMode = "lumina-reply_with_at";
//        } else if(!this.requireRespAt && this.requireRespReply) {
//            this.respMode = "lumina-reply_last_message";
//        } else {
//            this.respMode = respMode;
//        }
//    }

    public List<Long> getBlackQQUserList() {
        return blackQQUserList;
    }

    public void setBlackQQUserList(List<Long> blackQQUserList) {
        this.blackQQUserList = blackQQUserList;
    }

    public List<Long> getBlackQQGroupList() {
        return blackQQGroupList;
    }

    public void setBlackQQGroupList(List<Long> blackQQGroupList) {
        this.blackQQGroupList = blackQQGroupList;
    }
}
