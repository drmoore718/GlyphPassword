package nonoobs.glyphpassword;

import android.app.KeyguardManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

/**
 * Created by Doug on 2016-11-05.
 */

public class GlyphPasswordService extends Service
{
    BroadcastReceiver mReceiver;

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_BOOT_COMPLETED);

        mReceiver = new GlyphPasswordReceiver();
        registerReceiver(mReceiver, filter);

        super.onCreate();
    }

    public void onDestroy()
    {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }
}
