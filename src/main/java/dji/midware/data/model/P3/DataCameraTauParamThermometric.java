package dji.midware.data.model.P3;

import android.support.annotation.Keep;
import dji.fieldAnnotation.EXClassNullAway;
import dji.midware.data.config.P3.CmdIdCamera;
import dji.midware.data.config.P3.CmdSet;
import dji.midware.data.config.P3.DataConfig;
import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.model.P3.DataCameraTauParamer;
import dji.midware.data.packages.P3.SendPack;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.util.BytesUtil;

@Keep
@EXClassNullAway
public class DataCameraTauParamThermometric extends DataCameraTauParamer {
    public DataCameraTauParamThermometric() {
        this.mParamCmd = DataCameraTauParamer.ParamCmd.REGION_THERMOMETRIC;
    }

    public DataCameraTauParamThermometric setValue(float xAxis, float yAxis) {
        this.mParams = new byte[8];
        System.arraycopy(BytesUtil.getBytes(xAxis), 0, this.mParams, 0, 4);
        System.arraycopy(BytesUtil.getBytes(yAxis), 0, this.mParams, 4, 4);
        return this;
    }

    public float getXAxis() {
        return ((Float) get(0, 4, Float.class)).floatValue();
    }

    public float getYAxis() {
        return ((Float) get(4, 4, Float.class)).floatValue();
    }

    public void start(DJIDataCallBack callBack) {
        SendPack pack = new SendPack();
        pack.senderType = DeviceType.APP.value();
        pack.receiverType = DeviceType.CAMERA.value();
        pack.cmdType = DataConfig.CMDTYPE.REQUEST.value();
        pack.isNeedAck = DataConfig.NEEDACK.YES.value();
        pack.encryptType = DataConfig.EncryptType.NO.value();
        pack.cmdSet = CmdSet.CAMERA.value();
        pack.cmdId = CmdIdCamera.CmdIdType.TauParam.value();
        pack.timeOut = 3000;
        pack.repeatTimes = 1;
        start(pack, callBack);
    }
}
