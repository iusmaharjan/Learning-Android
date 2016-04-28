package com.iusmaharjan.eventbussample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private EventBus bus = EventBus.getDefault();

    private TextView statusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        statusText = new TextView(this);
        statusText.setPadding(20,20,20,20);

        setContentView(statusText);

        bus.register(this);
    }

    @Override
    protected void onStop() {
        bus.unregister(this);
        super.onStop();
    }

    @Subscribe
    public void onBusEvent(ChargingEvent event) {
        statusText.setText(String.format("%s\n%s",statusText.getText(),event.getData()));
    }
}
