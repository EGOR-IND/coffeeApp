package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void displayQuant(int quant) {
        TextView quantity = (TextView) findViewById(R.id.quantity);
        quantity.setText(""+quant);
    }

    protected void displayPrice(int quant) {
        TextView price = (TextView) findViewById(R.id.price);
        price.setText("Total: "+ NumberFormat.getCurrencyInstance(new Locale("en","in")).format(quantity*50));
    }

    public void increament(View view) {
        if (quantity<30){
            quantity++;
            displayQuant(quantity);
            displayPrice(quantity);
        }
    }

    public void decreament(View view) {
        if (quantity>0){
            quantity--;
            displayQuant(quantity);
            displayPrice(quantity);
        }
    }
    public void orderSummary(View view) {
        EditText nameEditText = (EditText) findViewById(R.id.name);
        String name = nameEditText.getText().toString();

        CheckBox whipCream = (CheckBox) findViewById(R.id.whippedCream);
        CheckBox choco = (CheckBox) findViewById(R.id.chocolate);

        String summary = "Extras:\n" ;
        if (whipCream.isChecked())
            summary += "Whipped Cream\n";
        if (choco.isChecked())
            summary += "Chocolate\n";
        if (!whipCream.isChecked() && !choco.isChecked())
            summary += "No extras!\n";

        TextView orderSum = (TextView) findViewById(R.id.price);
        orderSum.setText("Name: "+name+"\n"+summary+"Quantity: "+quantity+"\nTotal: "+NumberFormat.getCurrencyInstance(new Locale("en","in")).format(quantity*50)+"\nThank you!");
    }
}
