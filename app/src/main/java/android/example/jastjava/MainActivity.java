package android.example.jastjava;
/**
 * ВАЖНО: Убедитесь, что вы используете правильное имя пакета.* В этом примере используется имя пакета:
 ** package com.example.android.justjava
 * Если вы получаете сообщение об ошибке при копировании этого кода в Android studio, обновите его, чтобы оно соответствовало найденному имени пакета
 * в рамках проекта AndroidManifest.xml файл.
 **/
//////
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int numberOfCoffees = 2;
    int cennik = 50;
    int cennikChokolad;
    int cennikCream;
    int totalPrice;
    private Toast plusToast;
    private Toast minusToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Создаем переменную и привязываем ее к текст вью
    // Внимание!: тут название переменной и название текствью совпадают
    //TextView quantitytextview = (TextView) findViewById(R.id.quantitytextview);

    // Создадим переменную чтобы задавать начальное количество чашек кофе из
    // текстового поля quantitytextview.
    // но нужно преобразовать из текста в число из текст quantitytextview
   //  long defNumbCoff = Long.parseLong(quantitytextview.getText().toString());

    // метод чекбокса
    public boolean onCheckBoxClicked(View view) {
        CheckBox checkBox11 = findViewById(R.id.checkbox1);
        boolean isCheckBox11 = checkBox11.isChecked();
       // Если чекбокс истина то ценник за шоколад 20
        if (isCheckBox11) {cennikChokolad = 20;
        }else {cennikChokolad = 0;}// иначе 0
        return isCheckBox11;
    }

    public boolean onCheckBoxClicked2(View view) {
        CheckBox checkBox22 = findViewById(R.id.checkbox2);
        boolean isCheckBox22 = checkBox22.isChecked();
        // Если чекбокс истина то ценник за сливки 15
        if (isCheckBox22) {cennikCream = 15; // иначе 0
        }else {cennikCream = 0;}
        return isCheckBox22;
    }

    // Этот метод вызывается при нажатии кнопки " + "..
    // This metod is called when the " + " button is clicked.
    public void submitOrder(View view) {
        if (numberOfCoffees >= 99) {
            plusToast = Toast.makeText(getBaseContext(),
                    "нельзя заказать более 99 кофе", Toast.LENGTH_SHORT);
            plusToast.show();
        }else {
          display(++numberOfCoffees);}

    }
    // Этот метод вызывается при нажатии кнопки " - ".
    public void submitOrder2(View view) {
        if(numberOfCoffees <= 1) {
            minusToast = Toast.makeText(getBaseContext(),
                    "нельзя заказать меньше 1 чашки", Toast.LENGTH_SHORT);
            minusToast.show();
        } else {
        display(--numberOfCoffees); }
    }

    // Этот метод Заполняет окно "Количество" на экране.
    private void display(int AAA) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantitytextview);
        quantityTextView.setText(AAA + " чаш. кофе");
    }
    // При нажатии кнопки Order (Заказать)
    // сумма по чеку = (ценник за чашку + шоколад + сливки) * количество чашек
    // ценник же = ценник за кофе + ценник за шокол + ценник за сливки
    public void orderTotal(View view) {

        totalPrice = (cennik + cennikChokolad + cennikCream) * numberOfCoffees;
        displayTotalPrice(createOrderSummery(totalPrice, numberOfCoffees, view));
    }

    // Этот метод заполняет окно тоталПрайс на экране.
    private void displayTotalPrice(String message) {
        TextView totalPriceTextView = (TextView) findViewById(R.id.totalPrice_text_view);
        totalPriceTextView.setText(message);
  }

    //Этот метод формирует сообщение столбцом в несколько строк
    private String createOrderSummery(int totalPrice, int numberOfCoffees, View view) {
        String message = "Имя: " + ((EditText)findViewById(R.id.name_text_view)).getText();
        message += "\nВзбитые сливки? " + onCheckBoxClicked(view);
        message += "\nШоколад? " + onCheckBoxClicked2(view);
        message += "\nКолличество: " + numberOfCoffees;
        message += "\nЦена: " + totalPrice + " рублей";
        message += "\nСпасибо!";
        return message;
    }
}