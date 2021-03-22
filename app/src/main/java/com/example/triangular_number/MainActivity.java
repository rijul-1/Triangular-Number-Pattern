package com.example.triangular_number;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView number = findViewById(R.id.text_number);
        Button check_it_button = (Button) findViewById(R.id.check_it_button);
        TextView pattern_print_display = findViewById(R.id.pattern_print_display);
        Button print_pattern_button = (Button) findViewById(R.id.print_pattern_button);
        final int[] flag = {1};
        final int[] length = {0};
        check_it_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pattern_print_display.setText("");
                length[0] = 0;
                flag[0] = 1;
                int entered_num = Integer.parseInt(number.getText().toString());
                int sum = 0;
                for (int i = 0 ; i<entered_num ;i++){
                    sum = sum + i;
                    length[0]++;
                    if(sum == entered_num){
                        Toast.makeText(MainActivity.this ,"Entered Number is a Triangular Number!!",Toast.LENGTH_SHORT).show();
                        flag[0] = 2;
                        break;
                    }
                }

                if (flag[0] == 1){
                    Toast.makeText(MainActivity.this ,"Entered Number is not a Triangular Number!!",Toast.LENGTH_SHORT).show();
                    flag[0] = 3;
                }

            }
        });

        print_pattern_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag[0] == 1){
                    Toast.makeText(MainActivity.this , "Please Check It First Before Printing!!",Toast.LENGTH_SHORT).show();
                }
                if(flag[0] == 2){
                    StringBuilder Pattern = new StringBuilder();
                    pattern_print_display.setText("Pattern is: \n\n");
                    for(int i = 0 ; i<length[0] ; i++){
                        Pattern.append("* ");
                        String beforePattern = (String) pattern_print_display.getText();
                        pattern_print_display.setText(String.format("%s\n",beforePattern + Pattern));
                    }
                }
                if(flag[0] == 3){
                    Toast.makeText(MainActivity.this ,"Entered Number is not a Triangular Number So can't Print Pattern!!",Toast.LENGTH_SHORT).show();

                }
                number.setText("");

            }
        });
    }
}