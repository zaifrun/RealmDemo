package org.webdevelopment.realmdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    Realm realm;

    @BindView(R.id.listView)
    ListView listView;

    public void addStudent(Student student) {
        realm.beginTransaction();
        Student realmStudent = realm.createObject(Student.class,student.getId());
        realmStudent.setName(student.getName());
        realmStudent.setBirthday(student.getBirthday());
        realmStudent.setEmail(student.getEmail());
        realm.commitTransaction();
    }


    public ArrayList<Student> getAllStudents() {
        RealmResults results = realm.where(Student.class).findAll();
        ArrayList<Student> list = new ArrayList<>();
        list.addAll(results);
        return list;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        realm = Realm.getDefaultInstance();
        Random rand = new Random(System.currentTimeMillis());
        long r = rand.nextInt();
        if (r<0) r = -r;
        Student s1 = new Student(r,"martin", Calendar.getInstance().getTime(),"makn@makn.dk");
        addStudent(s1);

        ArrayList<Student> students = getAllStudents();
        ArrayAdapter<Student> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,students);

        listView.setAdapter(adapter);

    }
}
