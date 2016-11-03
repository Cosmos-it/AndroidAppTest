package cosmos.com.simpleCalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Pattern;

import modal.CalculatorService;

public class MainActivity extends AppCompatActivity {
    public TextView _screen;
    private String display = "";
    private String display1 = "";
    public String currentOperator = "";
    private ArrayList<String> listOfOperation;
    private static final String TAG = MainActivity.class.getSimpleName();
    CalculatorService calculatorService = new CalculatorService();
    private String input = new String();
    private StringBuilder test;
    public int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(cosmos.com.simpleCalculator.R.layout.activity_main);
        listOfOperation = new ArrayList<>();
        _screen = (TextView) findViewById(cosmos.com.simpleCalculator.R.id.textView);
        _screen.setText(display);

        final Button button0 = (Button) findViewById(R.id._0Button);
        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display += button0.getText();
                input += display;
                listOfOperation.add(display.toString());
                counter++;
                updateScreen();
            }
        });
        final Button button1 = (Button) findViewById(R.id._1button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display += button1.getText();
                input += display;
                counter++;
                listOfOperation.add(display.toString());
                updateScreen();
            }
        });
        final Button button2 = (Button) findViewById(R.id._2button);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display += button2.getText();
                input += display;
                listOfOperation.add(display.toString());
                counter++;
                updateScreen();
            }
        });
        final Button button3 = (Button) findViewById(R.id._3button);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display += button3.getText();
                input += display;
                listOfOperation.add(display.toString());
                updateScreen();
            }
        });
        final Button button4 = (Button) findViewById(R.id._4button);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display += button4.getText();
                input += display;

                listOfOperation.add(display.toString());
                updateScreen();
            }
        });
        final Button button5 = (Button) findViewById(R.id._5button);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display += button5.getText();
                input += display;
                listOfOperation.add(display.toString());
                counter++;
                updateScreen();
            }
        });
        final Button button6 = (Button) findViewById(R.id._6button);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display += button6.getText();
                input += display;
                listOfOperation.add(display.toString());
                updateScreen();
            }
        });
        final Button button7 = (Button) findViewById(R.id._7button);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display += button7.getText();
                input += display;
                listOfOperation.add(display.toString());
                counter++;
                updateScreen();
            }
        });
        final Button button8 = (Button) findViewById(R.id._8button);
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display += button8.getText();
                input += display;
                listOfOperation.add(display.toString());
                updateScreen();
            }
        });
        final Button button9 = (Button) findViewById(R.id._9button);
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display += button9.getText();
                input += display;
                listOfOperation.add(display.toString());
                counter++;
                updateScreen();
            }
        });
        final Button add = (Button) findViewById(R.id._addButton);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display += add.getText();
                input += display;
                listOfOperation.add(display.toString());
                counter++;
                updateScreen();
            }
        });
        final Button subtract = (Button) findViewById(R.id._subtractButton);
        subtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display += subtract.getText();
                input += display;
                listOfOperation.add(display.toString());
                counter++;
                updateScreen();
            }
        });


    }

    private void updateScreen() {
        _screen.setText(display);


    }

//    public void onClickNumber(View v) {
//        Button button = (Button) v;
//        display += button.getText();
//        listOfOperation.add(display.toString());
//        updateScreen();
//
//    }
//
//    public void onClickOperation(View v) {
//        Button button = (Button) v;
//        display += button.getText();
//        listOfOperation.add(display.toString());
//        updateScreen();
//    }

    private void clear() {
        display = "";
        listOfOperation.clear();
        counter = 0;
        input = "";

    }

    public void onClickEquals(View view) {
        Log.d(TAG, input + " Input counter: " + String.valueOf(counter));
        _screen.setText(display + "\n" + String.valueOf(calculatorService.operation(input.toString(), counter)));

    }

    public void onClickClear(View view) {
        clear();
        updateScreen();

    }

}
