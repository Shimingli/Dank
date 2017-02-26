package me.saket.dank.widgets.InboxUI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.alexvasilkov.gestures.views.GestureImageView;

import me.saket.dank.widgets.ScrollingRecyclerViewSheet;

/**
 * Moves its child View in parallax with respect to a {@link ScrollingRecyclerViewSheet}.
 */
public class SubmissionParallaxImageContainer extends FrameLayout {

    private int parallaxThresholdHeight;
    private GestureImageView childView;

    public SubmissionParallaxImageContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (getChildCount() > 1) {
            throw new IllegalStateException("Can only have one child");
        }
        childView = (GestureImageView) child;
        super.addView(child, index, params);
    }

//    /**
//     * Set the minimum value, beyond which no parallax will be performed.
//     * In our case, this will be the visible height of the child ImageView.
//     */
//    public void setThresholdHeightForParallax(int heightThreshold) {
//        parallaxThresholdHeight = heightThreshold;
//        parallaxOffsetChild(heightThreshold);
//    }
//
//    public void syncParallaxWith(ScrollingRecyclerViewSheet sheet) {
//        sheet.addOnSheetScrollChangeListener(scrollY -> {
//            float offsetY = scrollY + sheet.getTop();
//            if (offsetY < parallaxThresholdHeight) {
//                offsetY = parallaxThresholdHeight;
//            }
//            parallaxOffsetChild(offsetY);
//        });
//    }
//
//    private void parallaxOffsetChild(float sheetScrollYFromParentTop) {
//        float parallaxAmount = sheetScrollYFromParentTop - parallaxThresholdHeight;
//        float targetTranslationY = -(childView.getHeight() / 2 - parallaxThresholdHeight / 2) + parallaxAmount / 2;
//
//        if (childView.getTranslationY() != targetTranslationY) {
//            childView.setTranslationY(targetTranslationY);
//        }
//    }

//    @Override
//    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//        // Bug workaround: SubsamplingScaleImageView blocks parent ViewGroup from receiving touch
//        // events as soon as it receives one. Disallow it from doing so until it's zoomed in.
//        if (childView.getScale() > childView.getMinScale()) {
//            //Timber.w("Letting disallow. Image scale: %s, min. scale: %s", childView.getScale(), childView.getMinScale());
//            super.requestDisallowInterceptTouchEvent(disallowIntercept);
//            //} else {
//            //Timber.i("Blocking disallow. Image scale: %s, min. scale: %s", childView.getScale(), childView.getMinScale());
//        }
//    }

}