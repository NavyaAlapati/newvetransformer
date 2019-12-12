package com.mmg.vetransformers.details;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mmg.vetransformers.R;
import com.mmg.vetransformers.commonutiles.Global_Access;
import com.mmg.vetransformers.commonutiles.RecyclerTouchListener;
import com.mmg.vetransformers.database.DBHelper;
import com.mmg.vetransformers.model.RegistrationVo;

import java.util.ArrayList;

public class Activity_Details extends Activity
{
    RecyclerView details_recyclerview;
    Details_Adapter details_adapter;
    TextView title;
    DBHelper dbHelper;
    ArrayList<RegistrationVo> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dummy);
        dbHelper = new DBHelper(this);
        viewBinds();
        //method
    }

    private void viewBinds() {
        details_recyclerview = findViewById(R.id.recyclerview);
        title = findViewById(R.id.title);
        title.setText("Details");
        data = dbHelper.getAllCotacts();

        setDataToRecyclerView(data);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        details_recyclerview.setLayoutManager(layoutManager);
        details_recyclerview.setItemAnimator(new DefaultItemAnimator());
        details_adapter = new Details_Adapter(this,data);
        details_recyclerview.setAdapter(details_adapter);
    }

    public void setDataToRecyclerView(final ArrayList<RegistrationVo> data) {
        details_recyclerview.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), details_recyclerview, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                //showAlertDialog(position);
                final Global_Access global_access = Global_Access.getInstance();
                global_access.setId(position);
                global_access.setName(data.get(position).getName());
                global_access.setMobilenumber(data.get(position).getMobilenumber());
                global_access.setEmail(data.get(position).getEmail());
                global_access.setAmount(data.get(position).getAmount());
                global_access.setOthers(data.get(position).getOther());
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
    }
}
