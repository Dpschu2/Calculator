package io.github.httpsdpschu2.calcpractice;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.github.httpsdpschu2.calcpractice.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    private double valueOne = Double.NaN;
    private double valueTwo = Double.NaN;
    private double oneSave = 0.0;
    private double twoSave = 0.0;

    private String textOne = "";
    private String textTwo = "";

    private DecimalFormat decimalFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        decimalFormat = new DecimalFormat("#.##########");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = binding.editText.getText() + ".";
                binding.editText.setText(r);
            }
        });

        binding.buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = binding.editText.getText() + "1";
                binding.editText.setText(r);
            }
        });

        binding.buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = binding.editText.getText() + "2";
                binding.editText.setText(r);
            }
        });

        binding.buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = binding.editText.getText() + "3";
                binding.editText.setText(r);
            }
        });

        binding.buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = binding.editText.getText() + "4";
                binding.editText.setText(r);
            }
        });

        binding.buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = binding.editText.getText() + "5";
                binding.editText.setText(r);
            }
        });

        binding.buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = binding.editText.getText() + "6";
                binding.editText.setText(r);
            }
        });

        binding.buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = binding.editText.getText() + "7";
                binding.editText.setText(r);
            }
        });

        binding.buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = binding.editText.getText() + "8";
                binding.editText.setText(r);
            }
        });

        binding.buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = binding.editText.getText() + "9";
                binding.editText.setText(r);
            }
        });


        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = binding.editText.getText().toString();
                if (!a.substring(a.length() - 1).equals("+") && !a.substring(a.length() - 1).equals("-") &&
                        !a.substring(a.length() - 1).equals("*") && !a.substring(a.length() - 1).equals("/") &&
                        !a.equals("")) {
                    if (!binding.editText.getText().toString().equals("")) {
                        CURRENT_ACTION = ' ';
                        computeCalculation();
                    }
                    CURRENT_ACTION = ADDITION;
                    binding.editText.setText(binding.editText.getText());
                    String r = a + "+";
                    binding.editText.setText(r);
                }
            }
        });

        binding.buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = binding.editText.getText().toString();
                if (!a.substring(a.length() - 1).equals("+") && !a.substring(a.length() - 1).equals("-") &&
                        !a.substring(a.length() - 1).equals("*") && !a.substring(a.length() - 1).equals("/") &&
                        !a.equals("")) {
                    if (!binding.editText.getText().toString().equals(""))
                        computeCalculation();
                    CURRENT_ACTION = SUBTRACTION;
                    binding.editText.setText(binding.editText.getText());
                    String r = a + "-";
                    binding.editText.setText(r);
                }
            }
        });

        binding.buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = binding.editText.getText().toString();
                if (!a.substring(a.length() - 1).equals("+") && !a.substring(a.length() - 1).equals("-") &&
                        !a.substring(a.length() - 1).equals("*") && !a.substring(a.length() - 1).equals("/") &&
                        !a.equals("")) {
                    if (!binding.editText.getText().toString().equals(""))
                        computeCalculation();
                    CURRENT_ACTION = MULTIPLICATION;
                    binding.editText.setText(binding.editText.getText());
                    String r = a + "*";
                    binding.editText.setText(r);
                }
            }
        });

        binding.buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = binding.editText.getText().toString();
                if (!a.substring(a.length() - 1).equals("+") && !a.substring(a.length() - 1).equals("-") &&
                        !a.substring(a.length() - 1).equals("*") && !a.substring(a.length() - 1).equals("/") &&
                        !a.equals("")) {
                    if (!binding.editText.getText().toString().equals(""))
                        computeCalculation();
                    CURRENT_ACTION = DIVISION;
                    binding.editText.setText(binding.editText.getText());
                    String r = a + "/";
                    binding.editText.setText(r);
                }
            }
        });

        binding.buttonBacker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bind = binding.editText.getText().toString();
                if (!bind.contains("=")) {
                    if (bind.length() == 1) {
                        binding.editText.setText("");
                        valueOne = Double.NaN;
                        valueTwo = Double.NaN;
                    }
                    else if(bind.substring(bind.length() - 1).equals("+") ||
                            bind.substring(bind.length() - 1).equals("-") ||
                            bind.substring(bind.length() - 1).equals("*") ||
                            bind.substring(bind.length() - 1).equals("/")){
                        binding.editText.setText(bind.substring(0, bind.length() - 1));
                        CURRENT_ACTION = ' ';
                    }
                    else {
                        binding.editText.setText(bind.substring(0, bind.length() - 1));
                        valueTwo = Double.NaN;
                    }
                }
                else{
                    binding.editText.setText(bind.split("\n")[0]);
                    valueOne = oneSave;
                }
            }
        });
        binding.buttonLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(textOne + "\n" + textTwo);
                valueOne = oneSave;
                valueTwo = twoSave;
            }
        });
        binding.buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = binding.editText.getText() + "0";
                binding.editText.setText(r);
            }
        });
        binding.buttonSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sequence = binding.editText.getText().toString();
                String[] s = sequence.split("\\+|\\-|\\*|\\/");
                String[] r = sequence.split("= ");
                /*if (r[1].substring(0,1).equals("-")){
                    binding.editText.setText(r[1].substring(1));
                }*/
                if (sequence.contains("=")){
                    binding.editText.setText("-" + r[1]);
                }

                //(nothing)
                else if (sequence.equals("")){
                    String d = sequence + "-";
                    binding.editText.setText(d);
                }
                //-
                else if (sequence.equals("-")){
                    binding.editText.setText("");
                }
                //-2
                else if(sequence.substring(0,1).equals("-") && sequence.split("-")[0].equals("") &&
                        !sequence.contains("+") && !sequence.contains("*") && !sequence.contains("/")){
                    binding.editText.setText(sequence.split("-")[1]);
                }
                //2
                else if(!sequence.equals("") && !sequence.contains("+") && !sequence.contains("-") &&
                        !sequence.contains("*") && !sequence.contains("/")){
                    String c = "-" + sequence;
                    binding.editText.setText(c);
                }
                //2+
                else if (sequence.substring(sequence.length() - 1).equals("+") ||
                        sequence.substring(sequence.length() - 1).equals("-") && !sequence.contains("+-") &&
                                !sequence.contains("--") && !sequence.contains("*-") && !sequence.contains("/-") ||
                        sequence.substring(sequence.length() - 1).equals("*") ||
                        sequence.substring(sequence.length() - 1).equals("/")){
                    String a = sequence + "-";
                    binding.editText.setText(a);
                }
                //-2+
                else if(sequence.substring(sequence.length() - 1).equals("+") && sequence.substring(0,1).equals("-") ||
                        sequence.substring(sequence.length() - 1).equals("-") && sequence.substring(0,1).equals("-") && !sequence.contains("+-") &&
                                !sequence.contains("--") && !sequence.contains("*-") && !sequence.contains("/-") ||
                        sequence.substring(sequence.length() - 1).equals("*") && sequence.substring(0,1).equals("-") ||
                        sequence.substring(sequence.length() - 1).equals("/") && sequence.substring(0,1).equals("-")){
                    String d = sequence + "-";
                    binding.editText.setText(d);
                }
                //-2+-
                else if(sequence.substring(0,1).equals("-") && sequence.contains("+-") && sequence.substring(sequence.length() - 1).equals("-") ||
                        sequence.substring(0,1).equals("-") && sequence.contains("--") && sequence.substring(sequence.length() - 1).equals("-") ||
                        sequence.substring(0,1).equals("-") && sequence.contains("*-") && sequence.substring(sequence.length() - 1).equals("-") ||
                        sequence.substring(0,1).equals("-") && sequence.contains("/-") && sequence.substring(sequence.length() - 1).equals("-")){
                    binding.editText.setText(sequence.substring(0,sequence.length() - 1));
                }
                //2+2
                else if(!sequence.contains("+-") && !sequence.contains("--") && !sequence.contains("*-") && !sequence.contains("/-")){
                    int size = s[1].length();
                    if (sequence.substring(0, 1).equals("-")){
                        binding.editText.setText(sequence.substring(0, sequence.length() - (size)) +
                                "-" + s[2]);
                    }else {
                        binding.editText.setText(sequence.substring(0, sequence.length() - (size)) +
                                "-" + sequence.substring(s[0].length() + 1));
                    }
                }
                //2+-
                else if(!sequence.substring(0,1).equals("-") && sequence.contains("+-") && sequence.substring(sequence.length() - 1).equals("-") ||
                        !sequence.substring(0,1).equals("-") && sequence.contains("--") && sequence.substring(sequence.length() - 1).equals("-") ||
                        !sequence.substring(0,1).equals("-") && sequence.contains("*-") && sequence.substring(sequence.length() - 1).equals("-") ||
                        !sequence.substring(0,1).equals("-") && sequence.contains("/-") && sequence.substring(sequence.length() - 1).equals("-")){
                    binding.editText.setText(sequence.substring(0,sequence.length() - 1));
                }
                //2+-2
                else if(!sequence.substring(0,1).equals("-") && !s[2].equals("")){
                    int size = s[2].length();
                    String d = sequence.substring(0, sequence.length() - (size + 1)) + s[2];
                    binding.editText.setText(d);
                }
                //-2+-2
                else{
                    int size = s[3].length();
                    String d = sequence.substring(0, sequence.length() - (size + 1)) + s[3];
                    binding.editText.setText(d);
                }
            }

        });
        binding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String line3 = "";
                if(binding.editText.getText().toString().contains("=")) {
                    String[] lines = binding.editText.getText().toString().split("\n");
                    if (!lines[1].isEmpty()) {
                        String line2 = lines[1];
                        textTwo = line2.split("= ")[1];
                        line3 = lines[0];
                    }
                }
                else
                    line3 = binding.editText.getText().toString();
                oneSave = valueOne;
                twoSave = valueTwo;
                textOne = line3;
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                binding.editText.setText("");
            }
        });
        binding.buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int size = binding.editText.getText().toString().length();
                if (!binding.editText.getText().toString().substring(size - 1).equals("+") &&
                        !binding.editText.getText().toString().substring(size - 1).equals("-") &&
                        !binding.editText.getText().toString().substring(size - 1).equals("*") &&
                        !binding.editText.getText().toString().substring(size - 1).equals("/")) {
                    //if (!line2.equals(binding.editText.getText().toString().split("\\\n")[0]))
                    //    binding.editText.setText("");
                    if (valueTwo == Double.NaN)
                        valueTwo = 0.0;
                    computeCalculation();
                    String r = decimalFormat.format(valueOne);
                    binding.editText.setText(binding.editText.getText().toString() + "\n= " + r);
                }
            }
        });
    }
    private void computeCalculation() {
        if(!Double.isNaN(valueOne) && CURRENT_ACTION != ' ') {
            String sequence = binding.editText.getText().toString();
            String[] s = sequence.split("\\+|\\-|\\*|\\/");
            if(CURRENT_ACTION != ADDITION && CURRENT_ACTION != SUBTRACTION &&
                    CURRENT_ACTION != MULTIPLICATION && CURRENT_ACTION != DIVISION){
                valueTwo = 0.0;
                if (sequence.substring(0,1).equals("-"))
                    valueOne = parseDouble(s[1]) * -1;
                else
                    valueOne = parseDouble(s[0]);
            }
            else {
                if (!sequence.contains("=") && CURRENT_ACTION != ' ') {
                    //-2+-2
                    if ((sequence.contains("+-") && sequence.substring(0, 1).equals("-") || sequence.contains("--") && sequence.substring(0, 1).equals("-") ||
                            sequence.contains("*-") && sequence.substring(0, 1).equals("-") || sequence.contains("/-")) && sequence.substring(0, 1).equals("-"))
                        valueTwo = (Double.parseDouble(s[3]) * -1);
                        //2+-2
                    else if (sequence.contains("+-") || sequence.contains("--") || sequence.contains("*-") || sequence.contains("/-"))
                        valueTwo = (Double.parseDouble(s[2]) * -1);
                        //-2+2
                    else if (sequence.substring(0, 1).equals("-"))
                        valueTwo = Double.parseDouble(s[2]);
                        //2+2
                    else{
                        valueTwo = Double.parseDouble(s[1]);
                    }
                }
            }
            if(CURRENT_ACTION == ADDITION) {
                oneSave = valueOne;
                valueOne = this.valueOne + valueTwo;
            }
            else if(CURRENT_ACTION == SUBTRACTION) {
                oneSave = valueOne;
                valueOne = this.valueOne - valueTwo;
            }
            else if(CURRENT_ACTION == MULTIPLICATION) {
                oneSave = valueOne;
                valueOne = this.valueOne * valueTwo;
            }
            else if(CURRENT_ACTION == DIVISION) {
                oneSave = valueOne;
                valueOne = this.valueOne / valueTwo;
            }
        }
        else {
            try {
                valueOne = parseDouble(binding.editText.getText().toString());
            }
            catch (Exception e){
                System.out.println("Error");
            }
        }
    }
}

