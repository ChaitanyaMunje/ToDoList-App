package com.chaitanyamunje.assignmenttask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddTask extends AppCompatActivity {

    public static final String EXTRA_ID =
            "com.chaitanyamunje.assignmenttask.EXTRA_ID";
    public static final String EXTRA_TITLE =
            "com.chaitanyamunje.assignmenttask.EXTRA_TASK_NAME";
    public static final String EXTRA_DESCRIPTION =
            "com.chaitanyamunje.assignmenttask.EXTRA_TASK_DESCRIPTION";
    public static final String EXTRA_PRIORITY =
            "com.chaitanyamunje.assignmenttask.EXTRA_TASK_PRIORITY";
    public static final String EXTRA_STATUS=
            "com.chaitanyamunje.assignmenttask.EXTRA_TASK_STATUS";

    private EditText edt_task_name,edt_task_status,edt_task_desc;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edt_task_name=findViewById(R.id.task_name);
        edt_task_status=findViewById(R.id.task_status);
        edt_task_desc=findViewById(R.id.task_desc);
        numberPicker=findViewById(R.id.number_picker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Edit Task");
            edt_task_name.setText(intent.getStringExtra(EXTRA_TITLE));
            edt_task_desc.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            numberPicker.setValue(intent.getIntExtra(EXTRA_PRIORITY, 1));
            edt_task_status.setText(intent.getStringExtra(EXTRA_STATUS));

        } else {
            setTitle("Add Task");
        }
        Button savebtn=findViewById(R.id.save_btn);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTask();
            }
        });
    }


    private void saveTask() {
        String task_name = edt_task_name.getText().toString();
        String task_desc = edt_task_desc.getText().toString();
        String task_status=edt_task_status.getText().toString();
        int priority = numberPicker.getValue();

        if (task_name.trim().isEmpty() || task_desc.trim().isEmpty() || task_status.isEmpty()) {
            Toast.makeText(this, "Please insert a task name and description", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, task_name);
        data.putExtra(EXTRA_DESCRIPTION, task_desc);
        data.putExtra(EXTRA_PRIORITY, priority);
        data.putExtra(EXTRA_STATUS,task_status);
        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
            data.putExtra(EXTRA_ID, id);
        }
        setResult(RESULT_OK, data);
        finish();
    }
}
