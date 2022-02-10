package com.wimonsiri.appspinnerimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
    AdapterView.OnItemSelectedListener, View.OnClickListener {
        private String [] inputs = { "Pakistan", "Iran", "China", "India",
                "Thailand", "U.A.E", "Yemen", "Palestine",
                "America", "Australia", "Turkey", "England",
                "France", "Greece"};
        private String [] names = {

                "deosai_land", "dudipatsar_lake","rama_lake"};

        private ImageView display;
        private Spinner spinner1, spinner2;
        private ImageButton btnSave, btnView;
        private int pos1 = 0, pos2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            spinner1 = (Spinner) findViewById(R.id.spinner1);
            ArrayAdapter<String> country = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item,inputs);
            spinner1.setAdapter(country);
            spinner1.setOnItemSelectedListener(this);
            btnSave = (ImageButton) findViewById(R.id.imageShow);
            btnSave.setOnClickListener(this);
            spinner2 = (Spinner) findViewById(R.id.spinner2);
            ArrayAdapter<String> pictures = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, names);
            spinner2.setAdapter(pictures);
            spinner2.setOnItemSelectedListener(this);
            btnView = (ImageButton) findViewById(R.id.btnView);
            btnView.setOnClickListener(this);
            display = (ImageView) findViewById(R.id.imageShow);
    }

        @Override
        public void onClick(View view) {
            int id = view.getId();
            String message = "";
            if (id == R.id.imageShow) {
                message = "Country : " + spinner1.getItemAtPosition(pos1);
                Toast.makeText(this, "You select : " + inputs[pos1],

                        Toast.LENGTH_SHORT).show();

            }
            else if (id == R.id.btnView) {
                if (pos2 == 0)
                    display.setImageResource(R.drawable.deosai_land);
                else if (pos2 == 1)
                    display.setImageResource(R.drawable.dudipatsar_lake);
                else if (pos2 == 2)
                    display.setImageResource(R.drawable.rama_lake);
                message = "Picture : " + spinner2.getItemAtPosition(pos2);
                Toast.makeText(this, "You select : " + names[pos2],

                        Toast.LENGTH_SHORT).show();

            }
}
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i,
        long l) {
            int id = adapterView.getId();
            if (id == R.id.spinner1) {
                pos1 = i;
                Toast.makeText(this, inputs[pos1], Toast.LENGTH_SHORT).show();
            }
            else if (id == R.id.spinner2) {
                pos2 = i;
                Toast.makeText(this, names[pos2], Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }