package android.example.jastjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //Получаем данные из МайнАктивитиДжава
        Intent i = getIntent();
        // Проверяем пришло ли сообщения, а то может там пусто
        if(i != null)
        { // Если не пусто то отправим это сообщение в журнал Логов Д (дебаг)
            Log.d("MyLog", "Result string :" + i.getStringExtra("key_1"));
            // тут еще добавим значение по умолчанию
            Log.d("MyLog", "Result int :" + i.getIntExtra("key_2",0));
            // тут тоже необходимо значение по умолчанию
            Log.d("MyLog", "Result boolean :" + i.getBooleanExtra("key_3", false));

        }

    }

    public void onClick2(View view) {
        Intent i = new Intent(Activity2.this, Activity3.class);
        startActivity(i);

    }

    // коментарии на Активити3 джава
    @Override
    public void onBackPressed(){
        finish();

    }

}