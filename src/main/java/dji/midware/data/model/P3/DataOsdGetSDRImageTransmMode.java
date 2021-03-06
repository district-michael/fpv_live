package dji.midware.data.model.P3;

import android.support.annotation.Keep;
import dji.fieldAnnotation.EXClassNullAway;
import dji.midware.data.config.P3.CmdIdOsd;
import dji.midware.data.config.P3.CmdSet;
import dji.midware.data.config.P3.DataConfig;
import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.model.P3.DataOsdSetSDRImageTransmMode;
import dji.midware.data.packages.P3.SendPack;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.interfaces.DJIDataSyncListener;

@Keep
@EXClassNullAway
public class DataOsdGetSDRImageTransmMode extends DataBase implements DJIDataSyncListener {
    private static DataOsdGetSDRImageTransmMode instance = null;

    public static synchronized DataOsdGetSDRImageTransmMode getInstance() {
        DataOsdGetSDRImageTransmMode dataOsdGetSDRImageTransmMode;
        synchronized (DataOsdGetSDRImageTransmMode.class) {
            if (instance == null) {
                instance = new DataOsdGetSDRImageTransmMode();
            }
            dataOsdGetSDRImageTransmMode = instance;
        }
        return dataOsdGetSDRImageTransmMode;
    }

    /* access modifiers changed from: protected */
    public void doPack() {
    }

    public void start(DJIDataCallBack callBack) {
        SendPack pack = new SendPack();
        pack.senderType = DeviceType.APP.value();
        pack.receiverType = DeviceType.OFDM.value();
        pack.receiverId = 0;
        pack.cmdType = DataConfig.CMDTYPE.REQUEST.value();
        pack.isNeedAck = DataConfig.NEEDACK.YES.value();
        pack.encryptType = DataConfig.EncryptType.NO.value();
        pack.cmdSet = CmdSet.OSD.value();
        pack.cmdId = CmdIdOsd.CmdIdType.GetSDRImageTransmissionMode.value();
        start(pack, callBack);
    }

    public DataOsdSetSDRImageTransmMode.SDRImageTransmMode getMode() {
        return DataOsdSetSDRImageTransmMode.SDRImageTransmMode.find(((Integer) get(0, 1, Integer.class)).intValue());
    }
}
