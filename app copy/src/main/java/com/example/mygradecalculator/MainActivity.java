package com.example.mygradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleClick(View v) {

        //variables needed
        double iaEarnedPoints;
        double tEarnedPoints;
        double mEarnedPoints;
        double fEarnedPoints;
        double iaPercent;
        double tPercent;
        double mPercent;
        double fPercent;
        double finalPercent;
        double iaPossiblePoints = 0;
        double tPossiblePoints = 0;
        double mPossiblePoints = 0;
        double fPossiblePoints = 0;

        //Formatting the decimal
        DecimalFormat FORMAT = new DecimalFormat("##.#");

        /* ***************
        * Get All Values *
        *****************/

        /* Individual Assignment */
        EditText iaEarnedEntered = findViewById(R.id.iaEarned);
            String iaEarnedPointsString = iaEarnedEntered.getText().toString();
                //If nothing was entered
                if (iaEarnedPointsString.length() == 0) {
                    //assume it to be zero
                    iaEarnedPoints = 0.00;
                }

                else {
                    iaEarnedPoints = Double.parseDouble(iaEarnedPointsString);
                }
        EditText iaPossibleEntered = findViewById(R.id.iaPossible);
            String iaPossiblePointsString = iaPossibleEntered.getText().toString();
                //if a string was entered
                if (iaPossiblePointsString.length() != 0) {
                    //get double value
                    iaPossiblePoints = Double.parseDouble(iaPossiblePointsString);
                }

        /* Team Project */
        EditText tEarnedEntered = findViewById(R.id.teamEarned);
            String tEarnedPointsString = tEarnedEntered.getText().toString();;
                //If nothing was entered
                if (tEarnedPointsString.length() == 0) {
                    //assume it to be zero
                    tEarnedPoints = 0.00;
                }

                else {
                    tEarnedPoints = Double.parseDouble(tEarnedPointsString);
                }
        EditText tPossibleEntered = findViewById(R.id.teamPossible);
            String tPossiblePointsString = tPossibleEntered.getText().toString();
                //if a string was entered
                if(tPossiblePointsString.length() != 0) {
                    //get double value
                    tPossiblePoints = Double.parseDouble(tPossiblePointsString);
                }

        /* Midterm Exam */
        EditText mEarnedEntered = findViewById(R.id.midtermEarned);
            String mEarnedPointsString = mEarnedEntered.getText().toString();
                //If nothing was entered
                if (mEarnedPointsString.length() == 0) {
                    //assume it to be zero
                    mEarnedPoints = 0.00;
                }

                else {
                    mEarnedPoints = Double.parseDouble(mEarnedPointsString);
                }
        EditText mPossibleEntered = findViewById(R.id.midtermPossible);
            String mPossiblePointsString = mPossibleEntered.getText().toString();
                //if a string was entered
                if (mPossiblePointsString.length() != 0) {
                    //get double vlaue
                    mPossiblePoints = Double.parseDouble(mPossiblePointsString);
                }

        /* Final Exam */
        EditText fEarnedEntered = findViewById(R.id.finalEarned);
            String fEarnedPointsString = fEarnedEntered.getText().toString();
                //If nothing was entered
                if (fEarnedPointsString.length() == 0) {
                    //assume it to be zero
                    fEarnedPoints = 0.00;
                }

                else {
                    fEarnedPoints = Double.parseDouble(fEarnedPointsString);
                }
        EditText fPossibleEntered = findViewById(R.id.finalPossible);
            String fPossiblePointsString = fPossibleEntered.getText().toString();
                //if a string was entered
                if (fPossiblePointsString.length() != 0) {
                    //get double value
                    fPossiblePoints = Double.parseDouble(fPossiblePointsString);
                }

        TextView display = findViewById(R.id.displayGrade);

        /* ***************************
        * Calculate Percentage Grade *
        ******************************/

            /* Individual Assignment Possible Points -> Error handling */
            //if nothing was entered or a 0 was entered for individual assignment points POSSIBLE --> IGNORE section
            if (iaPossiblePointsString.length() == 0 || iaPossiblePointsString.equals("0")) {

                //Team Project
                tPercent = ((tEarnedPoints / tPossiblePoints) * 100) * 0.30;

                //Midterm Exam
                 mPercent = ((mEarnedPoints / mPossiblePoints) * 100) * 0.30;

                //Final Exam
                fPercent = ((fEarnedPoints / fPossiblePoints) * 100) * 0.20;
                                                                   //(100/80)
                    finalPercent = (tPercent + mPercent + fPercent) * (1.25);
            }

            /* Team Project Possible Points - Error handling */
            //if nothing was entered or a 0 was entered for team project points POSSIBLE --> IGNORE section
            else if (tPossiblePointsString.length() == 0 || tPossiblePointsString.equals("0")) {
                //Individual Assignment
                iaPercent = ((iaEarnedPoints / iaPossiblePoints) * 100) * 0.20;

                //Midterm Exam
                mPercent = ((mEarnedPoints / mPossiblePoints) * 100) * 0.30;

                //Final Exam
                fPercent = ((fEarnedPoints / fPossiblePoints) * 100) * 0.20;
                                                                    //   (100/70)
                    finalPercent = (iaPercent + mPercent + fPercent) * (1.428571429);
            }

            /* Midterm Exam Possible Point - Error handling */
            //if nothing was entered or a 0 was entered for midterm exam points POSSIBLE --> IGNORE section
            else if (mPossiblePointsString.length() == 0 || mPossiblePointsString.equals("0")) {
                //Individual Assignment
                iaPercent = ((iaEarnedPoints / iaPossiblePoints) * 100) * 0.20;

                //Team Project
                tPercent = ((tEarnedPoints / tPossiblePoints) * 100) * 0.30;

                //Final Exam
                fPercent = ((fEarnedPoints / fPossiblePoints) * 100) * 0.20;
                                                                     //   (100/70)
                    finalPercent = (iaPercent + tPercent + fPercent) * (1.428571429);
            }

            /* Final Exam Possible Point - Error handling */
            //if nothing was entered or a 0 was entered for final exam points POSSIBLE --> IGNORE section
            else if (fPossiblePointsString.length() == 0 || fPossiblePointsString.equals("0")) {
                //Individual Assignment
                iaPercent = ((iaEarnedPoints / iaPossiblePoints) * 100) * 0.20;

                //Team Project
                tPercent = ((tEarnedPoints / tPossiblePoints) * 100) * 0.30;

                //Midterm Exam
                mPercent = ((mEarnedPoints / mPossiblePoints) * 100) * 0.30;
                                                                    //(100/80)
                    finalPercent = (iaPercent + tPercent + mPercent) * (1.25);
            }

        /* If every value was entered */
        else {
             //Individual Assignment
             iaPercent = ((iaEarnedPoints / iaPossiblePoints) * 100) * 0.20;

             //Team Project
             tPercent = ((tEarnedPoints / tPossiblePoints) * 100) * 0.30;

             //Midterm Exam
             mPercent = ((mEarnedPoints / mPossiblePoints) * 100) * 0.30;

             //Final Exam
             fPercent = ((fEarnedPoints / fPossiblePoints) * 100) * 0.20;

                finalPercent = iaPercent + tPercent + mPercent + fPercent;
        }

        /* ***********************
        * Calculate Letter Grade *
        **************************/

        char letterGrade;

        if (finalPercent >= 90) {
            letterGrade = 'A';
        }

        else if(finalPercent >= 80 && finalPercent < 90) {
            letterGrade = 'B';
        }

        else if(finalPercent >= 70 && finalPercent < 80) {
            letterGrade = 'C';
        }

        else if(finalPercent >= 60 && finalPercent < 70) {
            letterGrade = 'D';
        }

        else {
            letterGrade = 'F';
        }

        /* **********************
        * Format Display String *
        *************************/

        String displayGrades = FORMAT.format(finalPercent) + "% " + letterGrade;

        display.setText(displayGrades);

            iaEarnedEntered.setText("");
            iaPossibleEntered.setText("");

            tEarnedEntered.setText("");
            tPossibleEntered.setText("");

            mEarnedEntered.setText("");
            mPossibleEntered.setText("");

            fEarnedEntered.setText("");
            fPossibleEntered.setText("");
    }
}


