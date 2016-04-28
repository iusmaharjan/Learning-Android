package com.iusmaharjan.eventbussample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.greenrobot.eventbus.EventBus;

public class ChargingReceiver extends BroadcastReceiver {

    private EventBus bus = EventBus.getDefault();

    @Override
    public void onReceive(Context context, Intent intent) {
        ChargingEvent chargingEvent;

        switch (intent.getAction()) {
            case Intent.ACTION_POWER_CONNECTED:
                chargingEvent = new ChargingEvent("Charging");
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                chargingEvent = new ChargingEvent("Discharging");
                break;
            default:
                chargingEvent = new ChargingEvent("Unknown Status");
        }

        bus.post(chargingEvent);
    }
}
