package com.cyanogenmod.settings.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Startup extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent bootintent) {
        DoubleTapGesture.restore(context);
        CameraGesture.restore(context);
        MusicGesture.restore(context);
        TorchGesture.restore(context);
        CapacitiveButtons.restore(context);
    }
}
