package app.ua.cert.medwed.saveyourlife;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.StringTokenizer;

import app.ua.cert.medwed.saveyourlife.interfaces.KeysSharegPrefernces;

public class InputDataActivity extends AppCompatActivity {

    EditText etRost;
    EditText etVes;
    ImageButton imageButton;
    Spinner spinner;
    CheckBox checkBox;
    SharedPreferences sharedPreferencesRostVes;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_input_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner = (Spinner) findViewById(R.id.spinnerPol);
        ArrayAdapter <String> list = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getApplicationContext().getResources().getStringArray(R.array.select_your_pol));
        spinner.setAdapter(list);

        checkBox =(CheckBox) findViewById(R.id.checkBoxSmoking);
        etRost = (EditText) findViewById(R.id.editTextRost);
        etVes = (EditText) findViewById(R.id.editTextVes);
        imageButton=(ImageButton) findViewById(R.id.imageButton);
        imageButton.setVisibility(View.INVISIBLE);


        sharedPreferencesRostVes= getSharedPreferences(KeysSharegPrefernces.KEYS_SHARED_PREFERENCES,MODE_PRIVATE);






        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if ((etRost.getText().length() != 0) && (etVes.getText().length() != 0)) {
                    startActivity(new Intent(InputDataActivity.this, MenuActivity.class));

                    SharedPreferences.Editor editor = sharedPreferencesRostVes.edit();
                    editor.putString(KeysSharegPrefernces.SHARED_PREFERENCES_ROST, etRost.getText().toString());
                    editor.putString(KeysSharegPrefernces.SHARED_PREFERENCES_VES, etVes.getText().toString());
                    editor.apply();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Необходимо заполнить все поля", Toast.LENGTH_SHORT).show();
                }

                if (checkBox.isChecked())
                {
                    startActivity(new Intent(InputDataActivity.this, SmokeActivity.class));
                }
            }
        });

       etRost.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               etRost.setText(null);
               imageButton.setVisibility(View.VISIBLE);
               return false;
           }
       });


        etVes.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                etVes.setText(null);
                imageButton.setVisibility(View.VISIBLE);
                return false;
            }
        });







    }

}
