package dji.midware.data.model.P3;

import android.support.annotation.Keep;
import dji.fieldAnnotation.EXClassNullAway;
import dji.midware.data.config.P3.CmdIdRc;
import dji.midware.data.config.P3.CmdSet;
import dji.midware.data.config.P3.DataConfig;
import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.packages.P3.SendPack;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.interfaces.DJIDataSyncListener;

@Keep
@EXClassNullAway
public class DataRcSetRcUnitNLang extends DataBase implements DJIDataSyncListener {
    private static DataRcSetRcUnitNLang instance = null;
    private int mLang = 2;
    private int mUnit = 0;

    public static synchronized DataRcSetRcUnitNLang getInstance() {
        DataRcSetRcUnitNLang dataRcSetRcUnitNLang;
        synchronized (DataRcSetRcUnitNLang.class) {
            if (instance == null) {
                instance = new DataRcSetRcUnitNLang();
            }
            dataRcSetRcUnitNLang = instance;
        }
        return dataRcSetRcUnitNLang;
    }

    public DataRcSetRcUnitNLang setUnit(int _unit) {
        this.mUnit = _unit;
        return this;
    }

    public DataRcSetRcUnitNLang setLang(int _lang) {
        this.mLang = _lang;
        return this;
    }

    public void start(DJIDataCallBack callBack) {
        SendPack pack = new SendPack();
        pack.senderType = DeviceType.APP.value();
        pack.receiverType = DeviceType.OSD.value();
        pack.cmdType = DataConfig.CMDTYPE.REQUEST.value();
        pack.isNeedAck = DataConfig.NEEDACK.YES.value();
        pack.encryptType = DataConfig.EncryptType.NO.value();
        pack.cmdSet = CmdSet.RC.value();
        pack.cmdId = CmdIdRc.CmdIdType.SetRcUnitNLang.value();
        start(pack, callBack);
    }

    /* access modifiers changed from: protected */
    public void doPack() {
        int setData = 0 + (1 << this.mLang) + (1 << (this.mUnit + 6));
        this._sendData = new byte[1];
        this._sendData[0] = (byte) setData;
    }
}
