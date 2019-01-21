package abircse.recyclerviewpractice.recyclearview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private List<employee> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.myrecyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        loaddata();
        adapter = new RecyclerAdapter(employeeList);
        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(employee emp, int position) {

                Toast.makeText(getApplicationContext(),emp.getName()+" & "+emp.getAddress(),Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(adapter);

    }

    private void loaddata() {

        employeeList = new ArrayList<>();
        employeeList.add(new employee("Abir","Khurushkul"));
        employeeList.add(new employee("Qareeb","Cox's Bazar"));

    }
}
