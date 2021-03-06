package dji.midware.data.model.P3;

import android.support.annotation.Keep;
import android.text.TextUtils;
import dji.fieldAnnotation.EXClassNullAway;
import dji.midware.data.config.P3.CmdIdCommon;
import dji.midware.data.config.P3.CmdSet;
import dji.midware.data.config.P3.DataConfig;
import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.packages.P3.SendPack;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.interfaces.DJIDataSyncListener;

@Keep
@EXClassNullAway
public class DataCommonGetSNOfMavicRC extends DataBase implements DJIDataSyncListener {
    private DeviceType deviceType = DeviceType.DM368_G;

    public DataCommonGetSNOfMavicRC() {
        this.receiverID = 1;
    }

    public int getDataLen() {
        return ((Integer) get(0, 2, Integer.class)).intValue();
    }

    public String getSN() {
        String sn = getUTF8(2, getDataLen());
        if (!TextUtils.isEmpty(sn)) {
            return sn;
        }
        return null;
    }

    public DataCommonGetSNOfMavicRC setDeviceType(DeviceType deviceType2) {
        this.deviceType = deviceType2;
        return this;
    }

    /* access modifiers changed from: protected */
    public void doPack() {
        this._sendData = new byte[1];
        this._sendData[0] = 1;
    }

    public void start(DJIDataCallBack callBack) {
        SendPack pack = new SendPack();
        pack.senderType = DeviceType.APP.value();
        pack.receiverType = this.deviceType.value();
        pack.cmdType = DataConfig.CMDTYPE.REQUEST.value();
        pack.isNeedAck = DataConfig.NEEDACK.YES.value();
        pack.encryptType = DataConfig.EncryptType.NO.value();
        pack.timeOut = 4000;
        pack.cmdSet = CmdSet.COMMON.value();
        pack.cmdId = CmdIdCommon.CmdIdType.GetSerialNumberOfMavicRC.value();
        start(pack, callBack);
    }
}
