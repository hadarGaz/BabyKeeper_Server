package com.babykeeper.babykeeper.model;

public class ResponsObj {
    private boolean actionSucceed;
    private String errorMsg;
    private String userId;
    private SettingInfo settingInfo;

    public ResponsObj(boolean actionSucceed, String errorMsg, String userId) {
        this.actionSucceed = actionSucceed;
        this.errorMsg = errorMsg;
        this.userId = userId;
    }

    public boolean isActionSucceed() {
        return actionSucceed;
    }

    public void setActionSucceed(boolean actionSucceed) {
        this.actionSucceed = actionSucceed;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public SettingInfo getSettingInfo() {
        return settingInfo;
    }

    public void setSettingInfo(SettingInfo settingInfo) {
        this.settingInfo = settingInfo;
    }
}
