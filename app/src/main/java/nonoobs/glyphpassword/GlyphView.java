package nonoobs.glyphpassword;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

/**
 * Created by Doug on 2016-11-05.
 */

public class GlyphView extends View
{
    private static final String[] GLYPHS = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    private boolean     mTouchDown  = false;
    private float       mLastTouchX = 0;
    private float       mLastTouchY = 0;
    private float       mCurrTouchX = 0;
    private float       mCurrTouchY = 0;

    public GlyphView(Context context)
    {
        super(context);

        //generateGrid();
    }

    public void onDraw(Canvas canvas)
    {
        Random r = new Random();
        Paint p = new Paint();
        int px = getContext().getResources().getDimensionPixelSize(R.dimen.text_size);
        p.setTextSize(px);
        p.setColor(0xFFFFFFFF);
        p.setStyle(Paint.Style.FILL);

        Paint x = new Paint();
        x.setTextSize(px);
        x.setColor(0xFF000000);
        x.setStyle(Paint.Style.STROKE);
        x.setStrokeWidth(px*0.02f);

        canvas.drawARGB(0xFF, 0x80, 0x80, 0x80);

        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                int rand = r.nextInt(10);
                canvas.drawText(GLYPHS[rand], i * px + (mCurrTouchX - mLastTouchX), j * px + (mCurrTouchY - mLastTouchY), p);
                canvas.drawText(GLYPHS[rand], i * px + (mCurrTouchX - mLastTouchX), j * px + (mCurrTouchY - mLastTouchY), x);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                mTouchDown = true;
                mLastTouchX = event.getX();
                mLastTouchY = event.getY();
                return true;

            case MotionEvent.ACTION_UP:
                if (mTouchDown)
                {
                    // Do test
                    mTouchDown = false;
                }
                break;

            case MotionEvent.ACTION_MOVE:
                mCurrTouchX = event.getX();
                mCurrTouchY = event.getY();
                invalidate();
                break;
        }


        return super.onTouchEvent(event);
    }
}
