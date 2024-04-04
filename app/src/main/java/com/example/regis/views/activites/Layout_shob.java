package com.example.regis.views.activites;

import android.os.Bundle;
import android.view.Menu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.regis.R;
import com.example.regis.databinding.ActivityLayoutShobBinding;
import com.example.regis.views.fragments.Add_Transaction_Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class Layout_shob extends AppCompatActivity {

    ActivityLayoutShobBinding binding;
    Calendar calendar;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLayoutShobBinding.inflate(getLayoutInflater());
        setContentView(binding.bottomNavigationView2);


         getSupportActionBar().setTitle("Transaction");
        EdgeToEdge.enable(this);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Transaction");
        calendar = Calendar.getInstance();
        updateDate();

       binding.nextDateBtn.setOnClickListener(c -> {
            calendar.add(Calendar.DATE, 1);
            updateDate();
       });

        binding.PreviousDateBtn.setOnClickListener(c -> {
            calendar.add(Calendar.DATE, -1);
            updateDate();
        });

        binding.floatingActionButton.setOnClickListener(c -> {
            new Add_Transaction_Fragment().show(getSupportFragmentManager(), null);
        });


    }

    void updateDate(){
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd MMMM,YYYY", Locale.FRANCE);
        binding.currentDate.setText(dateFormat.format(calendar.getTime()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

}