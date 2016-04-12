package com.iusmaharjan.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iusmaharjan.realm.model.Person;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private LinearLayout rootLayout = null;

    private Realm realm;
    private RealmConfiguration realmConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = ((LinearLayout)findViewById(R.id.container));
        rootLayout.removeAllViews();

        realmConfig = new RealmConfiguration.Builder(this).schemaVersion(1).migration(new RealmMigration() {
            @Override
            public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
                RealmSchema schema = realm.getSchema();

                if (oldVersion == 0) {
                    schema.get("Person").addField("address", String.class);
                }
            }
        }).build();
        realm = Realm.getInstance(realmConfig);

        createPerson(realm);
        readPerson(realm);
        updatePerson(realm);
        //deletePerson(realm);
    }

    private void showStatus(String text) {
        Timber.i(text);
        TextView textView = new TextView(this);
        textView.setText(text);
        rootLayout.addView(textView);
    }

    private void createPerson(Realm realm) {
        showStatus("Adding Person...");
        realm.beginTransaction();
        Person person = realm.createObject(Person.class);
        person.setName("Ayush Maharjan");
        person.address = "Teku";
        person.setAge(23);
        realm.commitTransaction();
    }

    private void readPerson(Realm realm) {
        showStatus("Reading Person...");
        realm.beginTransaction();
        Person person = realm.where(Person.class).findFirst();
        showStatus(person.getDetails());
        realm.commitTransaction();
    }

    private void updatePerson(Realm realm) {
        showStatus("Updating Person...");
        realm.beginTransaction();
        Person person = realm.where(Person.class).findFirst();
        person.setAge(22);
        realm.commitTransaction();
    }

    private void deletePerson(Realm realm) {
        showStatus("Deleting Person...");
        realm.beginTransaction();
        realm.allObjects(Person.class).clear();
        realm.commitTransaction();
    }
}
