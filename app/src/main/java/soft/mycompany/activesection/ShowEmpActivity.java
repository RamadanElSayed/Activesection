package soft.mycompany.activesection;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

import soft.mycompany.activesection.Myclass.Departments;
import soft.mycompany.activesection.Myclass.Employees;

public class ShowEmpActivity extends AppCompatActivity {

    List<Employees> list;
    ArrayList<String>arrayList;
    Employees employees;
    int numberofcontextMenu;
     Dialog dialogDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_emp);
        final ListView listView = (ListView) findViewById(R.id.listView);
        registerForContextMenu(listView);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getallemployees());
        listView.setAdapter(arrayAdapter);

        AlertDialog.Builder builderconfirm=new AlertDialog.Builder(this);
        builderconfirm.setTitle("Delete:?");
        builderconfirm.setMessage("Are you sure you want to  delete  this Note");
        builderconfirm.setIcon(android.R.drawable.ic_dialog_alert);
        builderconfirm.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                employees=list.get(numberofcontextMenu);
                String nameofemp=employees.employee_name;

                arrayList.remove(numberofcontextMenu);
                arrayAdapter.notifyDataSetChanged();
                employees.deleteItem(nameofemp);

            }
        });
        builderconfirm.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        dialogDelete=builderconfirm.create();
    }
        ArrayList<String> getallemployees()
    {
        Select s=new Select();

        list=s.from(Employees.class).execute();

        //*******Work around*********//
        arrayList=new ArrayList<>();
        for (Employees k:list) {
            arrayList.add("ID :"+k.employee_id+"\n"+"Name :"+k.employee_name+"\n"+"Address :"+k.employee_address+"\n"+"DeptID :"+k.IdOfDEpartment);

            //  myList.add(m.getNotesTitle()+"\n"+m.getNotesData()+"\n"+"\n"+m.getDate());
        }


        return arrayList;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.menu,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        numberofcontextMenu=info.position;
        switch (item.getItemId())
        {
            case R.id.Update:
                employees=list.get(numberofcontextMenu);
                String nameofemp=employees.employee_name;
                String addressOfEmp=employees.employee_address;
                int EmpId=employees.employee_id;
                Intent J=new Intent(ShowEmpActivity.this,Update_Activity.class);
                J.putExtra("name",nameofemp);
                J.putExtra("address",addressOfEmp);

                J.putExtra("empId",EmpId);

                startActivity(J);

            return true;
            case R.id.Delete:
                dialogDelete.show();

                return true;
        }
        return false;
    }
}

