package dji.thirdparty.io.reactivex.internal.operators.completable;

import dji.thirdparty.io.reactivex.Completable;
import dji.thirdparty.io.reactivex.CompletableObserver;
import dji.thirdparty.io.reactivex.internal.disposables.EmptyDisposable;

public final class CompletableError extends Completable {
    final Throwable error;

    public CompletableError(Throwable error2) {
        this.error = error2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver s) {
        EmptyDisposable.error(this.error, s);
    }
}
