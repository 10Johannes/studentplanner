package com.immr.studentplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.immr.studentplanner.model.Professor;

public class ProfessorActivity extends AppCompatActivity {

    private DBHandler dbHandler;
    private int courseID;
    private TextView professorName;
    private TextView professorPhone;
    private TextView professorEmail;
    private String spinnerStart;
    private String courseEnd;
    private String courseStart;
    private String courseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        dbHandler = new DBHandler(this, null, null, 1);

        professorName = findViewById(R.id.lvProfessorName);
        professorPhone = findViewById(R.id.professorPhone);
        professorEmail = findViewById(R.id.professorEmail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            courseID = extras.getInt("editCourseID");
            courseName = (extras.getString("editCourseTitle"));
            courseStart = (extras.getString("editCourseStart"));
            courseEnd = (extras.getString("editCourseEnd"));
            courseID = extras.getInt("editCourseID");

            spinnerStart = extras.getString("editCourseStatus");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSave:
                Professor professor = new Professor(
                    professorName.getText().toString(),
                        professorPhone.getText().toString(),
                        professorEmail.getText().toString(),
                    courseID
                );
                dbHandler.addProfessor(professor);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
