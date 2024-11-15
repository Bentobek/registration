package com.example.registration;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText editText = findViewById(R.id.email);
        Button button = findViewById(R.id.button);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().isEmpty()) {
                    button.setBackgroundTintList(getResources().getColorStateList(R.color.gray));
                } else {
                    button.setBackgroundTintList(getResources().getColorStateList(R.color.yellow));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });
        EditText username=findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        TextView text2 = findViewById(R.id.text2);
        LinearLayout line = findViewById(R.id.line);
        FrameLayout edit = findViewById(R.id.edit);
        findViewById(R.id.button).setOnClickListener(v -> {
            String userName = username.getText().toString().trim();
            String passwor = password.getText().toString().trim();

            if (TextUtils.isEmpty(passwor)){
                Toast.makeText(MainActivity.this, "Введите имя пользователя", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(userName)) {
                Toast.makeText(MainActivity.this, "Введите пароль", Toast.LENGTH_SHORT).show();
            } else if (userName.equals("admin") && passwor.equals("admin")) {
                Toast.makeText(MainActivity.this, "Успешный вход!", Toast.LENGTH_SHORT).show();
                text2.setVisibility(View.GONE);
                line.setVisibility(View.GONE);
                edit.setVisibility(View.GONE);
            } else {
                Toast.makeText(MainActivity.this, "Неверное имя пользователя или пароль", Toast.LENGTH_SHORT).show();
            }

        });

    }
}
