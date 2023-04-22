package android.example.jastjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    public void onClick3(View view) {
        Intent i = new Intent(Activity3.this, MainActivity.class);
        startActivity(i);
        //Чтобы после перехода не свернуть окно а закрыть делаем финиш
        // Но если будешь ждать на этой активити ответ, то финишь помешает
        finish();

    }

    // Поэтому закрытие вкладки (финиш) назначим на кнопку "назад" смартфона
    // добавляем слушателя кнопки "назад" на смартфоне
    @Override
    public void onBackPressed(){
        //Если убрать "супер" то на этой страничке кнопка
        // "назад" работать не будет
        // super.onBackPressed();

        //Заменим стандартное действие кнопки "назад" на действие "финиш"
        finish();

    }
}