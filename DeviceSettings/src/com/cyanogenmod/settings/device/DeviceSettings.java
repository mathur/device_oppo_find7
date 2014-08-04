package com.cyanogenmod.settings.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.TwoStatePreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;

public class DeviceSettings extends PreferenceActivity  {

    public static final String KEY_DOUBLETAPGESTURE = "doubletapgesture";
    public static final String KEY_CAMERAGESTURE = "cameragesture";
    public static final String KEY_MUSICGESTURE = "musicgesture";
    public static final String KEY_TORCHGESTURE = "torchgesture";
    public static final String KEY_CAPACITIVEBUTTONS = "capacitivebuttons";

    private TwoStatePreference mDoubleTapGesture;
    private TwoStatePreference mCameraGesture;
    private TwoStatePreference mMusicGesture;
    private TwoStatePreference mTorchGesture;
    private TwoStatePreference mCapacitiveButtons;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.main);

        mDoubleTapGesture = (TwoStatePreference) findPreference(KEY_DOUBLETAPGESTURE);
        mDoubleTapGesture.setEnabled(DoubleTapGesture.isSupported());
        mDoubleTapGesture.setOnPreferenceChangeListener(new DoubleTapGesture());

        mCameraGesture = (TwoStatePreference) findPreference(KEY_CAMERAGESTURE);
        mCameraGesture.setEnabled(CameraGesture.isSupported());
        mCameraGesture.setOnPreferenceChangeListener(new CameraGesture());

        mMusicGesture = (TwoStatePreference) findPreference(KEY_MUSICGESTURE);
        mMusicGesture.setEnabled(MusicGesture.isSupported());
        mMusicGesture.setOnPreferenceChangeListener(new MusicGesture());

        mTorchGesture = (TwoStatePreference) findPreference(KEY_TORCHGESTURE);
        mTorchGesture.setEnabled(TorchGesture.isSupported());
        mTorchGesture.setOnPreferenceChangeListener(new TorchGesture());

        mCapacitiveButtons = (TwoStatePreference) findPreference(KEY_CAPACITIVEBUTTONS);
        mCapacitiveButtons.setEnabled(CapacitiveButtons.isSupported());
        mCapacitiveButtons.setOnPreferenceChangeListener(new CapacitiveButtons());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
