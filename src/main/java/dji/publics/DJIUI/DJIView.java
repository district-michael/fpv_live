package dji.publics.DJIUI;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import dji.publics.interfaces.DJIViewAnimShowInterface;
import dji.publics.interfaces.DJIViewShowInterface;

public class DJIView extends View implements DJIViewShowInterface, DJIViewAnimShowInterface {
    private AnimatorListenerAdapter animGoListener = new AnimatorListenerAdapter() {
        /* class dji.publics.DJIUI.DJIView.AnonymousClass1 */

        public void onAnimationEnd(Animator animation) {
            DJIView.this.go();
            DJIView.this.animate().setListener(null);
        }
    };
    private AnimatorListenerAdapter animShowListener = new AnimatorListenerAdapter() {
        /* class dji.publics.DJIUI.DJIView.AnonymousClass2 */

        public void onAnimationStart(Animator animation) {
            DJIView.this.show();
        }

        public void onAnimationEnd(Animator animation) {
            DJIView.this.animate().setListener(null);
        }
    };

    public DJIView(Context context) {
        super(context);
    }

    public DJIView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void show() {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
    }

    public void hide() {
        if (getVisibility() != 4) {
            setVisibility(4);
        }
    }

    public void go() {
        if (getVisibility() != 8) {
            setVisibility(8);
        }
    }

    public void animGo() {
        animate().alpha(0.0f).setDuration(300).setListener(this.animGoListener).start();
    }

    public void animShow() {
        animate().alpha(1.0f).setDuration(300).setListener(this.animShowListener).start();
    }
}