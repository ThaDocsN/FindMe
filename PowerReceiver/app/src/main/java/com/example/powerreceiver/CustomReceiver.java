package com.example.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        String intentAction = intent.getAction();
        String toastMessage = "Unknown Intent Action";
        if (intentAction != null) {
            switch (intentAction) {
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = context.getString(R.string.powerConnected);
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = context.getString(R.string.powerDisconnect);
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = context.getString(R.string.custmBroadcast);
                    break;
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
