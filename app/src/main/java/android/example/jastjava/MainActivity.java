package android.example.jastjava;
/**
 * ВАЖНО: Убедитесь, что вы используете правильное имя пакета.* В этом примере используется имя пакета:
 ** package com.example.android.justjava
 * Если вы получаете сообщение об ошибке при копировании этого кода в Android studio, обновите его, чтобы оно соответствовало найденному имени пакета
 * в рамках проекта AndroidManifest.xml файл.
 **/
//////
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

// Ссылка на ютуб урок
// https://www.youtube.com/watch?v=lyGGar6U-HY
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick1(View view) {
        // Создаю интент и говорю что хочу перейти из этого (this) активити,
        // в активити2
        Intent i = new Intent(MainActivity.this, Activity2.class);

        //специальная функция для старта интента. После нее текущая активити
        // не закрывается, а сворачивается
        startActivity(i);

        //Сделал простейшие кнопки для перехода по активностям.
        // Но каждая предыдущая активити будет висеть в буфере и в истории.
    }


        // коментарии на Активити3 джава
        @Override
        public void onBackPressed(){
            finish();
        }

    }
