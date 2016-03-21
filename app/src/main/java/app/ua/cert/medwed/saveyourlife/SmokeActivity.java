package app.ua.cert.medwed.saveyourlife;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import app.ua.cert.medwed.saveyourlife.interfaces.KeysSharegPrefernces;

public class SmokeActivity extends AppCompatActivity
{
    CheckBox chBox1, chBox2, chBox3;
    EditText eT_cigarets;
    ImageButton iBnext;


    SharedPreferences sharedPreferencesCigaretsPerDay;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smoke);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        chBox1 = (CheckBox) findViewById(R.id.checkBox1);
        chBox2 = (CheckBox) findViewById(R.id.checkBox2);
        chBox3 = (CheckBox) findViewById(R.id.checkBox3);
        eT_cigarets =(EditText) findViewById(R.id.editText1);
        iBnext = (ImageButton) findViewById(R.id.imageButton1);
        iBnext.setVisibility(View.INVISIBLE);
        sharedPreferencesCigaretsPerDay =getSharedPreferences(KeysSharegPrefernces.KEYS_SHARED_PREFERENCES, MODE_PRIVATE);


        iBnext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (eT_cigarets.getText().length() != 0) {
                    startActivity(new Intent(SmokeActivity.this, MenuActivity.class));
                    SharedPreferences.Editor editor = sharedPreferencesCigaretsPerDay.edit();
                    editor.putString(KeysSharegPrefernces.SHARED_PREFERENCES_CIGARETS, eT_cigarets.getText().toString());
                    editor.apply();
                }

            }
        });



        eT_cigarets.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                eT_cigarets.setText(null);
                iBnext.setVisibility(View.VISIBLE);
                return false;
            }
        });



    }





    }


