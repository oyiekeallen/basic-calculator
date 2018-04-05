package com.allen.simpecalulator;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.allen.simpecalulator.databinding.ActivityMainBinding;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    private double firstValueInput = Double.NaN;
    private double secondValueInput;

    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        decimalFormat = new DecimalFormat("#.####");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        /*
         * Bind all buttons
         */
        binding.buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.secondOperatorEditText.setText(binding.secondOperatorEditText.getText() + ".");
            }
        });

        binding.buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.secondOperatorEditText.setText(binding.secondOperatorEditText.getText() + "0");
            }
        });

        binding.buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.secondOperatorEditText.setText(binding.secondOperatorEditText.getText() + "1");
            }
        });

        binding.buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.secondOperatorEditText.setText(binding.secondOperatorEditText.getText() + "2");
            }
        });

        binding.buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.secondOperatorEditText.setText(binding.secondOperatorEditText.getText() + "3");
            }
        });

        binding.buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.secondOperatorEditText.setText(binding.secondOperatorEditText.getText() + "4");
            }
        });

        binding.buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.secondOperatorEditText.setText(binding.secondOperatorEditText.getText() + "5");
            }
        });

        binding.buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.secondOperatorEditText.setText(binding.secondOperatorEditText.getText() + "6");
            }
        });

        binding.buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.secondOperatorEditText.setText(binding.secondOperatorEditText.getText() + "7");
            }
        });

        binding.buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.secondOperatorEditText.setText(binding.secondOperatorEditText.getText() + "8");
            }
        });

        binding.buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.secondOperatorEditText.setText(binding.secondOperatorEditText.getText() + "9");
            }
        });

        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                binding.firstOperatorTextView.setText(decimalFormat.format(firstValueInput) + "+");
                binding.secondOperatorEditText.setText(null);
            }
        });

        binding.buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                binding.firstOperatorTextView.setText(decimalFormat.format(firstValueInput) + "-");
                binding.secondOperatorEditText.setText(null);
            }
        });

        binding.buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                binding.firstOperatorTextView.setText(decimalFormat.format(firstValueInput) + "*");
                binding.secondOperatorEditText.setText(null);
            }
        });

        binding.buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                binding.firstOperatorTextView.setText(decimalFormat.format(firstValueInput) + "/");
                binding.secondOperatorEditText.setText(null);
            }
        });

        binding.buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                binding.firstOperatorTextView.setText(binding.firstOperatorTextView.getText().toString() +
                        decimalFormat.format(secondValueInput) + " = " + decimalFormat.format(firstValueInput));
                firstValueInput = 0;
                CURRENT_ACTION = '0';
            }
        });

        binding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.secondOperatorEditText.getText().length() > 0) {
                    CharSequence currentText = binding.secondOperatorEditText.getText();
                    binding.secondOperatorEditText.setText(currentText.subSequence(0, currentText.length()-1));
                }
                else {
                    firstValueInput = Double.NaN;
                    secondValueInput = Double.NaN;
                    binding.secondOperatorEditText.setText("");
                    binding.firstOperatorTextView.setText("");
                }
            }
        });
    }

    private void computeCalculation()
    {
        if(!Double.isNaN(firstValueInput))
        {
            secondValueInput = Double.parseDouble(binding.secondOperatorEditText.getText().toString());
            binding.secondOperatorEditText.setText(null);

            if(CURRENT_ACTION == ADDITION)
                firstValueInput = this.firstValueInput + secondValueInput;
            else if(CURRENT_ACTION == SUBTRACTION)
                firstValueInput = this.firstValueInput - secondValueInput;
            else if(CURRENT_ACTION == MULTIPLICATION)
                firstValueInput = this.firstValueInput * secondValueInput;
            else if(CURRENT_ACTION == DIVISION)
                firstValueInput = this.firstValueInput / secondValueInput;
        }
        else
            {
                try
                {
                    firstValueInput = Double.parseDouble(binding.secondOperatorEditText.getText().toString());
                }
                catch (Exception e){}
            }
    }
}
