package cosmos.com.simpleCalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

import modal.CalculatorClass;
import modal.CalculatorService;

public class MainActivity extends AppCompatActivity {
    public TextView _screen;
    private String display = "";
    public String currentOperator = "";
    private CalculatorClass calculatorOperations = new CalculatorClass();
    private CalculatorService calculatorService = new CalculatorService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(cosmos.com.simpleCalculator.R.layout.activity_main);

        _screen = (TextView)findViewById(cosmos.com.simpleCalculator.R.id.textView);
        _screen.setText(display);
    }

    private void updateScreen(){
        _screen.setText(display);

    }

    public void onClickNumber(View v){
        Button button = (Button)v;
        display +=  button.getText();
        updateScreen();
    }

    public void onClickOperation(View v){
        Button button = (Button) v;
        this.display += button.getText();
        currentOperator = button.getText().toString();
        updateScreen();
    }

    private void clear() {
        display = "";
        currentOperator = "";
    }

    public void onClickEquals(View view){

        String[] operation = display.split(Pattern.quote(currentOperator));

        if (operation.length < 2) return;

        Double _result = calculatorOperations.operation(operation[0], operation[1], currentOperator);
        _screen.setText(display + "\n" + String.valueOf(_result));
    }

    public void onClickClear(View view){
        clear();
        updateScreen();

    }

}
