package com.vfuchong.sptsm.common.enums;

/**
 * Created by Francis.zz on 2017/7/28.
 * 订单来源渠道
 */
public enum SourceOrderChnlEnum {
    HuaweiWallet("10", "HuaweiWallet"),
    VFC_WALLET("1", "VFC_WALLET"),
    TXCCM("2", "TXCCM"),
    OPPOWallet("3", "OPPOWallet"),
    TXCCM_HCE("4", "TXCCM_HCE"),
    Huawei_QingDao("5","Huawei_QingDao"),
    OPPOWalletDemo("6","OPPOWalletDemo"),
    OnePlusWallet("8","OnePlusWallet");

    public String value;
    public String desc;

    SourceOrderChnlEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static SourceOrderChnlEnum forValue(String value) {
        SourceOrderChnlEnum[] values = SourceOrderChnlEnum.values();
        for (SourceOrderChnlEnum e : values) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        return null;
    }
}
