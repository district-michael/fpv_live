package dji.midware.data.model.P3;

import android.support.annotation.Keep;
import dji.fieldAnnotation.EXClassNullAway;
import dji.midware.data.config.P3.CmdIdEYE;
import dji.midware.data.config.P3.CmdSet;
import dji.midware.data.config.P3.DataConfig;
import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.packages.P3.SendPack;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.interfaces.DJIDataSyncListener;

@Keep
@EXClassNullAway
public class DataEyeUavStatePushSwitch extends DataBase implements DJIDataSyncListener {
    private static DataEyeUavStatePushSwitch instance;
    private boolean isOpen = false;

    public static DataEyeUavStatePushSwitch getInstance() {
        if (instance == null) {
            instance = new DataEyeUavStatePushSwitch();
        }
        return instance;
    }

    private DataEyeUavStatePushSwitch() {
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public DataEyeUavStatePushSwitch setOpen(boolean open) {
        this.isOpen = open;
        return this;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, byte], vars: [r0v0 ?, r0v1 ?, r0v2 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    protected void doPack() {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            byte[] r2 = new byte[r0]
            boolean r3 = r4.isOpen
            if (r3 == 0) goto L_0x0009
            r0 = r1
        L_0x0009:
            r2[r1] = r0
            r4._sendData = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dji.midware.data.model.P3.DataEyeUavStatePushSwitch.doPack():void");
    }

    public void start(DJIDataCallBack callBack) {
        SendPack pack = new SendPack();
        pack.senderType = DeviceType.APP.value();
        pack.receiverType = DeviceType.SINGLE.value();
        pack.receiverId = 7;
        pack.cmdType = DataConfig.CMDTYPE.REQUEST.value();
        pack.isNeedAck = DataConfig.NEEDACK.YES.value();
        pack.encryptType = DataConfig.EncryptType.NO.value();
        pack.cmdSet = CmdSet.EYE.value();
        pack.cmdId = CmdIdEYE.CmdIdType.UavStatePushSwitch.value();
        pack.timeOut = 5000;
        pack.repeatTimes = 1;
        start(pack, callBack);
    }
}
