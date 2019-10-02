package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View;
import android.content.Context;
import android.os.Bundle;
import android.widget.ScrollView;

import com.example.contactlist.ContactListActivity;
import com.example.contactlist.ContactMapActivity;
import com.example.contactlist.R;

import static java.security.AccessController.getContext;

public class ContactSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_settings);
        initListButton();
        initMapButton();
        initSettingsButton();
        //initSettings();
        initSortByClick();
        initSortOrderClick();
        initBackgroundColorClick();

        ScrollView svo = (ScrollView) findViewById(R.id.ScrollView2);
        if (initSettings().equalsIgnoreCase("green")) {
            svo.setBackgroundResource(R.color.color1);

        }
        else if (initSettings().equalsIgnoreCase("blue")) {
            svo.setBackgroundResource(R.color.burr);

        }
        else {
            svo.setBackgroundResource(R.color.system_transparent);
        }

    }

    private void initListButton() {
        ImageButton ibList = (ImageButton) findViewById(R.id.imageButtonList);
        ibList.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(ContactSettingsActivity.this, ContactListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

    }

    private void initMapButton() {
        ImageButton ibMap = (ImageButton) findViewById(R.id.imageButtonMap);
        ibMap.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(ContactSettingsActivity.this, ContactMapActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

    }

    private void initSettingsButton() {

        ImageButton ibSettings = (ImageButton) findViewById(R.id.imageButtonSettings);
        ibSettings.setEnabled(false);

    }

    private String initSettings() {
        String sortBy = getSharedPreferences("MyContactListPreferences",
                Context.MODE_PRIVATE).getString("sortfield", "contactname");
        String sortOrder = getSharedPreferences("MyContactListPreferences",
                Context.MODE_PRIVATE).getString("sortorder", "ASC");
        String backgroundColor = getSharedPreferences("MyContactListPreferences",
                Context.MODE_PRIVATE).getString("backgroundcolor", "red");

        RadioButton rbName = findViewById(R.id.radioName);
        RadioButton rbCity = findViewById(R.id.radioCity);
        RadioButton rbBirthDay = findViewById(R.id.radioBirthday);

        if(sortBy.equalsIgnoreCase("contactname")) {
            rbName.setChecked(true);

        }
        else if (sortBy.equalsIgnoreCase("city")){
            rbCity.setChecked(true);

        }
        else {
            rbBirthDay.setChecked(true);

        }

        RadioButton rbAscending = findViewById(R.id.radioAscending);
        RadioButton rbDescending = findViewById(R.id.radioDescending);

        if (sortOrder.equalsIgnoreCase("ASC")) {
            rbAscending.setChecked(true);

        }
        else {
            rbDescending.setChecked(true);

        }

        RadioButton rbRed = findViewById(R.id.radioColorRed);
        RadioButton rbBlue = findViewById(R.id.radioColorBlue);
        RadioButton rbGrey = findViewById(R.id.radioColorGrey);
        if (backgroundColor.equalsIgnoreCase("green")) {
            rbRed.setChecked(true);
            return "green";

        }
        else if (backgroundColor.equalsIgnoreCase("blue")) {
            rbBlue.setChecked(true);
            return "blue";

        }
        else {
            rbGrey.setChecked(true);
            return "color3";

        }

    }

    private void initSortByClick() {
        RadioGroup rgSortBy = (RadioGroup) findViewById(R.id.radioGroupSortBy);
        rgSortBy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                RadioButton rbName = findViewById(R.id.radioName);
                RadioButton rbCity = findViewById(R.id.radioCity);

                if (rbName.isChecked()) {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit()
                            .putString("sortfield", "contactname").commit();

                }
                else if (rbCity.isChecked()) {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit()
                            .putString("sortfield", "city").commit();

                }
                else {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit()
                            .putString("sortfield", "birthday").commit();

                }

            }

        });

    }

    private void initSortOrderClick() {
        RadioGroup rgSortOrder = (RadioGroup) findViewById(R.id.radioGroupSortOrder);
        rgSortOrder.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                RadioButton rbAscending = findViewById(R.id.radioAscending);
                if (rbAscending.isChecked()) {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit()
                            .putString("sortorder", "ASC").commit();

                }
                else {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit()
                            .putString("sortorder", "DESC").commit();

                }

            }

        });

    }

    public void initBackgroundColorClick(){

        RadioGroup rgBackgroundColor = (RadioGroup) findViewById(R.id.radioBackgroundColor);
        rgBackgroundColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                RadioButton rbRed = findViewById(R.id.radioColorRed);
                RadioButton rbBlue = findViewById(R.id.radioColorBlue);
                if (rbRed.isChecked()) {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit()
                            .putString("backgroundcolor", "green").commit();

                    ScrollView svo = (ScrollView) findViewById(R.id.ScrollView2);
                    svo.setBackgroundResource(R.color.color1);

                }
                else if (rbBlue.isChecked()) {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit()
                            .putString("backgroundcolor", "blue").commit();

                    ScrollView svo = (ScrollView) findViewById(R.id.ScrollView2);
                    svo.setBackgroundResource(R.color.burr);

                }
                else {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit()
                            .putString("backgroundcolor", "color2").commit();

                    ScrollView svo = (ScrollView) findViewById(R.id.ScrollView2);
                    svo.setBackgroundResource(R.color.color2);

                }

            }

        });

    }
}