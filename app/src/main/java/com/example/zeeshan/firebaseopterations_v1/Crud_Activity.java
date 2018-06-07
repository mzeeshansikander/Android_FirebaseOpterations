package com.example.zeeshan.firebaseopterations_v1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Crud_Activity extends AppCompatActivity {

    DatabaseReference databaseReference;
    ListView lv_student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_);


        databaseReference = FirebaseDatabase.getInstance().getReference("Student");


    }
    public void addStudent(View view){
        EditText roll_no = findViewById(R.id.et_rollNo);
        EditText name = findViewById(R.id.et_name);

        String sRoll_no = roll_no.getText().toString();
        String sName = name.getText().toString();

        if (!TextUtils.isEmpty(sName)){
            String id = databaseReference.push().getKey();
            Student student = new Student(id,sRoll_no,sName);

            databaseReference.child(id).setValue(student);
            Toast.makeText(Crud_Activity.this,"Student Added",Toast.LENGTH_SHORT).show();

        }
    }
    public void clearStudent(View view){

        EditText roll_no = findViewById(R.id.et_rollNo);
        EditText studentName = findViewById(R.id.et_name);


        roll_no.setText("");
        studentName.setText("");

    }
    public void viewStudents(View view){
         lv_student = findViewById(R.id.lv_students);


         final List<String> student_List = new ArrayList();

         databaseReference.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 for (DataSnapshot studentShot: dataSnapshot.getChildren()){
                     student_List.add(studentShot.child("name").getValue().toString());
                     Log.e("TAG",studentShot.child("name").getValue().toString());
                 }
                 ArrayAdapter adapter = new ArrayAdapter(Crud_Activity.this,android.R.layout.simple_list_item_1,student_List);
                 lv_student.setAdapter(adapter);
             }
            @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }
         });



    }
}
