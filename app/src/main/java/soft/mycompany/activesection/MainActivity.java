package soft.mycompany.activesection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import soft.mycompany.activesection.Myclass.Departments;
import soft.mycompany.activesection.Myclass.Employees;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonemp=(Button)findViewById(R.id.buttonEmp);
        Button buttondept=(Button)findViewById(R.id.buttonDEpt);
        Button buttonsearch=(Button)findViewById(R.id.buttonEarch);
        Button buttonshow=(Button)findViewById(R.id.buttonShow);


        buttondept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,DeptActivity.class);
                startActivity(i);
            }
        });
        buttonemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,EmpActivity.class);
                startActivity(i);
            }
        });
        buttonsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,SerachActivity.class);
                startActivity(i);
//                Employees employees=new Employees();
//                List<Employees>mylist=employees.returndataaccordingname("ahmed");
//
//               Employees employees1=mylist.get(0);
//                int x=employees1.IdOfDEpartment;
//
//               Departments departments=new Departments();
//             List<Departments>list=departments.ReturndeptName(x);
//                Departments departments1=list.get(0);
//                Toast.makeText(MainActivity.this, ""+departments1.name_location, Toast.LENGTH_SHORT).show();

            }
        });
        buttonshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,ShowEmpActivity.class);
                startActivity(i);

            }
        });
    }
}
