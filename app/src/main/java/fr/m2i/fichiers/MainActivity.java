package fr.m2i.fichiers;

import android.Manifest;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    //creation de 2 variables
    private EditText etText1;
    private EditText etText2;
    private EditText etTextSaveExt;
    private EditText etTextLoadExt;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActivityCompat.requestPermissions(this,
                new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, 1);
    }

    public void save(View v) {

        //recuperation la zone de texte pui passage en chaine sur une variable
        etText1 = findViewById(R.id.etText1);
        text = etText1.getText().toString();

        //transformation en byte dans un tableau
        byte bytes[] = text.getBytes();
        try {
            FileOutputStream fos = openFileOutput("data.txt", MODE_PRIVATE);
            fos.write(bytes);
            fos.close();
        } catch (Exception ex) {
            Toast.makeText(this, "erreur", Toast.LENGTH_LONG).show();
        }


    }

    public void load(View v) {

        etText2 = findViewById(R.id.etText2);
        byte bytes[] = new byte[100];
        try {
            FileInputStream fis = openFileInput("data.txt");
            fis.read(bytes);
            fis.close();
        } catch (Exception ex) {
            Toast.makeText(this, "erreur", Toast.LENGTH_LONG).show();
        }
        String text = new String(bytes);
        etText2.setText(text.trim());

    }

    public void saveExterne(View v) {


        //recuperation la zone de texte pui passage en chaine sur une variable
        etTextSaveExt = findViewById(R.id.etText1);
        text = etTextSaveExt.getText().toString();

        //transformation en byte dans un tableau
        byte bytes[] = text.getBytes();
        try {
            FileOutputStream fos = openFileOutput("data.txt", MODE_PRIVATE);
            fos.write(bytes);
            fos.close();
        } catch (Exception ex) {
            Toast.makeText(this, "erreur", Toast.LENGTH_LONG).show();
        }





    }

    public void loadExterne(View v) {


        etTextLoadExt = findViewById(R.id.etText1);
        byte bytes[] = new byte[100];
        try {
            FileInputStream fis = openFileInput("data.txt");
            fis.read(bytes);
            fis.close();
        } catch (Exception ex) {
            Toast.makeText(this, "erreur", Toast.LENGTH_LONG).show();
        }
        String text = new String(bytes);
        etTextLoadExt.setText(text.trim());
    }


    }





