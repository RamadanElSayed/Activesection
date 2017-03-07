package soft.mycompany.activesection;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import soft.mycompany.activesection.Myclass.Departments;
import soft.mycompany.activesection.Myclass.Employees;

public class SerachActivity extends AppCompatActivity {
    List<Employees> list;
    ArrayList<String> arrayList;
    ArrayList<String> arrayList1;
    ListView listView ;
    String name2;
    String name;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serach);
        Employees employees=new Employees();
        list=employees.ReturnemployeesNmaes();
        final EditText editText=(EditText)findViewById(R.id.editText4);

        Button  button= (Button) findViewById(R.id.button2);
        listView = (ListView) findViewById(R.id.listView2);

       // listView.setBackgroundColor(Color.BLACK);
        name2=" ";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 name = editText.getText().toString();

                    arrayList1 = new ArrayList<>();

                    arrayList = new ArrayList<>();
                    for (Employees k : list) {
                        arrayList.add(k.employee_name);

                    }
                    for (int i = 0; i < arrayList.size(); i++) {

                        if (arrayList.get(i).toLowerCase().contains(name.toLowerCase())) {
                            name2 = arrayList.get(i);
                            arrayList1.add(name2);
                        }
                    }

                    if(name2.equals(" "))
                    {
                        Toast.makeText(SerachActivity.this, "This Name Not Found", Toast.LENGTH_SHORT).show();
                    }

                    else {
                        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList1);
                        listView.setAdapter(arrayAdapter);
                    }
                }


        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                  String NameOfEmp=  ((TextView)view).getText().toString();
                  Employees employees=new Employees();
                  List<Employees>mylist=employees.returndataaccordingname(NameOfEmp);

                   Employees employees1=mylist.get(0);
                String NameEmp=employees1.employee_name;
                String EmpAddress=employees1.employee_address;
                String EmpEmail=employees1.employee_email;
                String EmpPhone=employees1.employee_phone;
                int empID=employees1.employee_id;
                    int deptID=employees1.IdOfDEpartment;

                   Departments departments=new Departments();
                 List<Departments>list=departments.ReturndeptName(deptID);
                    Departments departments1=list.get(0);
                String DepartmentName=departments1.Dept_Location;
                Intent J=new Intent(SerachActivity.this,AllDtaAboutEmp.class);
                J.putExtra("name",NameEmp);
                J.putExtra("address",EmpAddress);
                J.putExtra("email",EmpEmail);
                J.putExtra("phone",EmpPhone);
                J.putExtra("deptname",DepartmentName);
                J.putExtra("empId",empID);

                startActivity(J);


            }
        });

    }

}
