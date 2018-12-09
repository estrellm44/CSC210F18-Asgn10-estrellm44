package edu.sunyulster.meldiesestrella.wordroomdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_WORD =
            "edu.sunyulster.meldiesestrella.wordroomdatabase.EXTRA_WORD";
    public static final String EXTRA_DEF =
            "edu.sunyulster.meldiesestrella.wordroomdatabase.EXTRA_DEF";

    private EditText mEditWordView;
    private  EditText mEditDefView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        mEditWordView = findViewById(R.id.edit_word);
        mEditDefView = findViewById(R.id.edit_Def);

        setTitle("Add A New Word");


        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditWordView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = mEditWordView.getText().toString();
                    String def = mEditDefView.getText().toString();
                    replyIntent.putExtra(EXTRA_WORD, word);
                    replyIntent.putExtra(EXTRA_DEF, def);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();

            }
        });
    }

}



