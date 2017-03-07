package soft.mycompany.activesection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

import soft.mycompany.activesection.Myclass.Departments;
import soft.mycompany.activesection.Myclass.Employees;

public class EmpActivity extends AppCompatActivity {
    List<Departments> list;
    List<Employees> listemployees;
    ArrayList<Integer> arrayListofemployee;
    ArrayList<Integer> arrayList;
    int dept_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp);
        final EditText employee_Name=(EditText)findViewById(R.id.editname);
        final EditText employee_phone=(EditText)findViewById(R.id.editphone);
        final EditText employee_email=(EditText)findViewById(R.id.editemail);
        final EditText employee_address=(EditText)findViewById(R.id.editaddress);
        final EditText employee_id=(EditText)findViewById(R.id.editempId);

        Button button=(Button)findViewById(R.id.button6);
        final Spinner spinner=(Spinner)findViewById(R.id.spinner);
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


                if ((employee_Name.getText().toString().equals(""))||( employee_phone.getText().toString().equals(""))
                ||(employee_email.getText().toString().equals(""))||(employee_address.getText().toString().equals(""))
                        ||(employee_id.getText().toString().equals(""))||(spinner.getSelectedItem().toString().equals("")))
                {

                    Toast.makeText(EmpActivity.this, "Please enter all data ", Toast.LENGTH_SHORT).show();
                } else {
                    Employees employees = new Employees();

                    employees.employee_name = employee_Name.getText().toString();
                    employees.employee_phone = employee_phone.getText().toString();
                    employees.employee_email = employee_email.getText().toString();
                    employees.employee_address = employee_address.getText().toString();
                    int emp_id = Integer.parseInt(employee_id.getText().toString());
                    employees.employee_id = emp_id;
                    employees.IdOfDEpartment = dept_id;
                    listemployees = employees.ReturnemployeesNmaes();

                    arrayListofemployee = new ArrayList<>();
                    for (Employees k : listemployees) {
                        arrayListofemployee.add(k.employee_id);

                    }
                    boolean flag = true;
                    for (int i = 0; i < arrayListofemployee.size(); i++) {
                        if (arrayListofemployee.get(i) == emp_id) {
                            flag = false;
                        }

                    }

                    if (flag == true) {
                        employees.save();
                        Toast.makeText(EmpActivity.this, "Employee Added", Toast.LENGTH_SHORT).show();
                        employee_Name.setText("");
                        employee_phone.setText("");
                        employee_email.setText("");
                        employee_address.setText("");
                        employee_id.setText("");
                    } else {
                        Toast.makeText(EmpActivity.this, "Please enter Id Instead that", Toast.LENGTH_SHORT).show();

                    }


                }
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

