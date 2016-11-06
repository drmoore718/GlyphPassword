package nonoobs.glyphpassword;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;

public class UnlockActivity extends Activity
{
    GlyphView mGlyphView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //setContentView(R.layout.activity_unlock);

        mGlyphView = new GlyphView(this);
        addContentView(mGlyphView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));


    }


}
