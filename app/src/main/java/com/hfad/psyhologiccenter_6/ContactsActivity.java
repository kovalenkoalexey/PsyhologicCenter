package com.hfad.psyhologiccenter_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        TextView main, about, contacts;

        main = (TextView) findViewById(R.id.main_scene);
        about = (TextView) findViewById(R.id.about);
        contacts = (TextView) findViewById(R.id.contacts);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ContactsActivity.this, CenterActivity.class);
                startActivity(mainIntent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent = new Intent(ContactsActivity.this, AboutUsActivity.class);
                startActivity(aboutIntent);
            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}