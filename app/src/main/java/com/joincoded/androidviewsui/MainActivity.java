package com.joincoded.androidviewsui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> question = new ArrayList<>();
    ArrayList<Boolean> answer = new ArrayList<>();
    int currentQuestionIndex = 0;

    TextView questionTextView, resultTextView;
    Button nextButton;
    Button trueButton;
    Button falseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTextView = findViewById(R.id.questionTextView);
        //questionTextView.setText("10");
        resultTextView = findViewById(R.id.resultTextView);
        nextButton = findViewById(R.id.nextButton);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);



        question.add("my name is faten?");
        answer.add(true);
        question.add("is faten 21 years old?");
        answer.add(false);
        question.add("is harry potter my fav movie?");
        answer.add(true);

        questionTextView.setText(question.get(currentQuestionIndex));

        nextButton.setOnClickListener(v -> {
            showNextQuestion();


        });
        trueButton.setOnClickListener(v -> {
            checkAnswer(true);


        });
        falseButton.setOnClickListener(v -> {
            checkAnswer(false);

        });


    }


    private void showNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < question.size()) {
            questionTextView.setText(question.get(currentQuestionIndex));
            resultTextView.setText("");

        }

    }

    private void checkAnswer(boolean myAnswer) {
        boolean correctAnswer = answer.get(currentQuestionIndex);
        if (myAnswer == correctAnswer) {
            resultTextView.setText("correct");
        } else {
            resultTextView.setText("wrong");
        }
    }
}
