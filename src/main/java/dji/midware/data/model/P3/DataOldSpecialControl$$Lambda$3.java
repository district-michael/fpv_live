package dji.midware.data.model.P3;

import io.reactivex.functions.Consumer;

final /* synthetic */ class DataOldSpecialControl$$Lambda$3 implements Consumer {
    private final DataOldSpecialControl arg$1;

    DataOldSpecialControl$$Lambda$3(DataOldSpecialControl dataOldSpecialControl) {
        this.arg$1 = dataOldSpecialControl;
    }

    public void accept(Object obj) {
        this.arg$1.lambda$sendLowLevel$3$DataOldSpecialControl((Long) obj);
    }
}
