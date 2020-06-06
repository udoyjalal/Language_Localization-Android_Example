package com.example.language;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.language.Helper.LocalHelper;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase, "en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

        Paper.init(this);

        String language = Paper.book().read("language");
        if (language == null)
            Paper.book().write("language", "en");

        updateView((String) Paper.book().read("language"));

    }

    private void updateView(String lang) {
        Context context = LocalHelper.setLocale(this, lang);
        Resources resources = context.getResources();

        textView.setText(resources.getString(R.string.Hello));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.language_en) {
            Paper.book().write("language", "en");
            updateView((String) Paper.book().read("language"));
        } else if (item.getItemId() == R.id.language_bn) {
            Paper.book().write("language", "bn");
            updateView((String) Paper.book().read("language"));
        }

        return true;
    }
}



































































