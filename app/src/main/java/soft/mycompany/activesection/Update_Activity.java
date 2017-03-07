package soft.mycompany.activesection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

import soft.mycompany.activesection.Myclass.Departments;
import soft.mycompany.activesection.Myclass.Employees;

public class Update_Activity extends AppCompatActivity {
    List<Departments> list;

    ArrayList<Integer> arrayList;
    Employees employees;
    int dept_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_);
        Intent i=getIntent();
        final String NameOfEmp=i.getExtras().getString("name");

        final String EmpAddress=i.getExtras().getString("address");

        final int empId=i.getExtras().getInt("empId");


        final EditText employee_Name=(EditText)findViewById(R.id.editText5_Name);
        final EditText employee_address=(EditText)findViewById(R.id.editText6_address);

        employee_Name.setText(NameOfEmp);
        employee_address.setText(EmpAddress);
        Button button=(Button)findViewById(R.id.button3_update);
        final Spinner spinner=(Spinner)findViewById(R.id.spinnerupdate);
        final ArrayAdapter<Integer> adapter=new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item, getAlldeptid() );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dept_id=Integer.parseInt(spinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                employees=new Employees();
                employees.updateItem(empId,employee_Name.getText().toString(),employee_address.getText().toString(),dept_id);
                Intent intent=new Intent(Update_Activity.this,ShowEmpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    ArrayList<Integer> getAlldeptid(){


        Select s=new Select();

        list=s.from(Departments.class).execute();

        //*******Work around*********//
        arrayList=new ArrayList<>();
        for (Departments k:list) {
            arrayList.add(k.department_id);

            //  myList.add(m.getNotesTitle()+"\n"+m.getNotesData()+"\n"+"\n"+m.getDate());
        }


        return arrayList;
    }
}
