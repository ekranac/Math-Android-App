package helpers;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import com.ekranac.root.mathapp.R;

import java.util.ArrayList;

/**
 * Created by root on 12/1/14.
 */
public class CalculatorHelper {



    EditText calcDisplay;
    public static void numClick(int num, EditText calcDisplay, ArrayList<String> equ)
    {

        if(num!=0)
        {
            if (Double.parseDouble(calcDisplay.getText().toString()) == 0.0 && !calcDisplay.getText().toString().contains("."))
            {
                calcDisplay.setText("");
            }


            calcDisplay.setText(calcDisplay.getText().toString() + Integer.toString(num));
            equ.add(Integer.toString(num));

        }

        else if(num==0)
        {
            if (Double.parseDouble(calcDisplay.getText().toString()) == 0.0 && !calcDisplay.getText().toString().contains("."))
            {
                calcDisplay.setText(calcDisplay.getText().toString());
            }
            else
            {
                calcDisplay.setText(calcDisplay.getText().toString() + Integer.toString(num));
                equ.add(Integer.toString(num));

            }
        }


    }

    public static void addOperator(String op, EditText calcDisplay, EditText oldCalcDisplay, ArrayList<String> equ)
    {

        String s = calcDisplay.getText().toString();

        if(equ.size()==0)
        {
            calcDisplay.setText("0");
        }
        else if(equ.get(equ.size()-1)=="÷" || equ.get(equ.size()-1)=="-" || equ.get(equ.size()-1)=="+" || equ.get(equ.size()-1)=="×")
        {
            equ.remove(equ.size() -1);
            oldCalcDisplay.setText(oldCalcDisplay.getText().toString().substring(0, oldCalcDisplay.getText().toString().length()-1));

            equ.add(op);
            oldCalcDisplay.setText(oldCalcDisplay.getText().toString() + op);
        }
        else
        {
            equ.add(op);

            oldCalcDisplay.setText(oldCalcDisplay.getText().toString() + calcDisplay.getText().toString() + op);
            calcDisplay.setText("0");
        }
    }
}
