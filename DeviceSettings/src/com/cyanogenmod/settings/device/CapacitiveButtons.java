package com.cyanogenmod.settings.device;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceManager;
import java.io.File;

public class CapacitiveButtons implements OnPreferenceChangeListener {

    private static final String FILE = "/proc/touchpanel/keypad_enable";

    public static boolean isSupported() {
        return Utils.fileExists(FILE);
    }

    /**
     * Restore button backlight setting from SharedPreferences. (Write to kernel.)
     * @param context       The context to read the SharedPreferences from
     */
    public static void restore(Context context) {
        if (!isSupported()) {
            return;
        }

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        boolean enabled = sharedPrefs.getBoolean(DeviceSettings.KEY_CAPACITIVEBUTTONS, false);
        File blFile = new File(FILE);
        blFile.setWritable(true);
        if(enabled) {
            Utils.writeValue(FILE, "1");
            blFile.setWritable(false);
        }
        else {
            Utils.writeValue(FILE, "0");
        }
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        Boolean enabled = (Boolean) newValue;
        File blFile = new File(FILE);
        blFile.setWritable(true);
        if(enabled) {
            Utils.writeValue(FILE, "1");
            blFile.setWritable(false);
        }
        else {
            Utils.writeValue(FILE, "0");
        }
        return true;
    }

}
