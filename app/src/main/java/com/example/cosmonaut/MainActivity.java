//package com.example.cosmonaut;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//
//import com.example.cosmonaut.databinding.ActivityMainBinding;
//
//
//public class MainActivity extends AppCompatActivity {
//    ActivityMainBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        binding.btnWriteWish.setOnClickListener(v -> {
//            binding.etMyWish.setVisibility(View.VISIBLE);
//            binding.btnPassWish.setVisibility(View.VISIBLE);
//
//            binding.btnWriteWish.setVisibility(View.INVISIBLE);
//
//        });
//
//        binding.btnPassWish.setOnClickListener(v1 -> {
//            Intent emailIntent = new Intent(Intent.ACTION_SEND);
//
//            emailIntent.setData(Uri.parse("mailto:"));
//            emailIntent.setType("text/plain");
//            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My message");
//
//            emailIntent.putExtra(Intent.EXTRA_TEXT, binding.etMyWish.getText().toString());
//
//            startActivity(emailIntent);
//        });
//    }
//}

package com.example.cosmonaut;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etMyWish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMyWish = findViewById(R.id.et_my_wish);

        findViewById(R.id.btn_write_wish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etMyWish.setVisibility(View.VISIBLE);
                findViewById(R.id.btn_pass_wish).setVisibility(View.VISIBLE);
                findViewById(R.id.btn_write_wish).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.btn_pass_wish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wish = etMyWish.getText().toString();
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My message");
                emailIntent.putExtra(Intent.EXTRA_TEXT, wish);
                startActivity(emailIntent);
            }
        });
    }
}
