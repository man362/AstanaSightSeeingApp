package com.androidapp.astanasightseeing.astanasightseeing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;

import static com.androidapp.astanasightseeing.astanasightseeing.Utility.chosenLanguage;

public class LanguagePage extends AppCompatActivity {

    ImageView iv_kazakh_lang;
    ImageView iv_russian_lang;
    ImageView iv_english_lang;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_page);

        iv_kazakh_lang =  (ImageView) findViewById(R.id.iv_kazakh_lang);
        iv_russian_lang = (ImageView) findViewById(R.id.iv_russian_lang);
        iv_english_lang = (ImageView) findViewById(R.id.iv_english_lang);
        final Intent intent = new Intent(LanguagePage.this, HomePage.class);

        iv_kazakh_lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLanguage("Kazakh");

                dialog = ProgressDialog.show(LanguagePage.this, "Translating",
                        "Loading ... ", true);
                new MyTask().execute("");

                chosenLanguage = "Kazakh";
            }
        });

        iv_russian_lang.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                setLanguage("Russian");

                dialog = ProgressDialog.show(LanguagePage.this, "Translating",
                        "Loading ... ", true);
                new MyTask().execute("");

                chosenLanguage = "Russian";
            }
        });

        iv_english_lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLanguage("English");

                dialog = ProgressDialog.show(LanguagePage.this, "Translating",
                        "Loading ... ", true);
                new MyTask().execute("");


                chosenLanguage = "English";
            }
        });
    }

    void setLanguage(String chosenLang){
        Utility.mPlaceList.clear();
        String language;

        switch(chosenLang){
            case "Russian":
                language="ru";
                break;
            case "English":
                language="en";
                break;
            default:
                language="tr";
                break;
        }

        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());

    }


    class MyTask extends AsyncTask<String, Integer, Void> {

        public MyTask(){

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //tvInfo.setText("Begin");
        }

        @Override
        protected Void doInBackground(String... urls) {
            Utility.populateTheList(Utility.mPlaceList, LanguagePage.this);
            return null;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //tvInfo.setText("Downloaded " + values[0] + " files");
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if (dialog.isShowing()) {
                dialog.dismiss();
            }

            Intent i = new Intent(LanguagePage.this,HomePage.class);
            startActivity(i);
            //tvInfo.setText("End");
        }
    }
}
