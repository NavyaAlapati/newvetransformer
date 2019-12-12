package com.mmg.vetransformers.details;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mmg.vetransformers.R;
import com.mmg.vetransformers.commonutiles.Global_Access;
import com.mmg.vetransformers.database.DBHelper;
import com.mmg.vetransformers.model.RegistrationVo;

import java.util.ArrayList;

public class Details_Adapter extends RecyclerView.Adapter<Details_Adapter.MyViewHolder>
{
    Context context;
    ArrayList<RegistrationVo> registrationVos;
    DBHelper dbHelper;//

    public Details_Adapter(Context context, ArrayList<RegistrationVo> registrationVos) {
        this.context =context;
        this.registrationVos = registrationVos;
        dbHelper = new DBHelper(context);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView names;
        TextView ph_number;
        TextView amount;
        TextView otherDeatails;
        TextView email;
        Button update;
        Button delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            names            = itemView.findViewById(R.id.names);
            ph_number        = itemView.findViewById(R.id.ph_number);
            amount           = itemView.findViewById(R.id.amount);
            email            = itemView.findViewById(R.id.email);
            otherDeatails    = itemView.findViewById(R.id.otherDeatails);
            update           = itemView.findViewById(R.id.update);
            delete           = itemView.findViewById(R.id.delete);
            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i = getAdapterPosition();
                    update(i);
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int j = getAdapterPosition();
                    delete(j);
                }
            });
        }
    }

    private void update(final int i) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.update_layout);
        dialog.setCancelable(true);
        dialog.show();
        final EditText fullname = dialog.findViewById(R.id.fullname);
        final EditText mobile = dialog.findViewById(R.id.mobile);
        final EditText emailId = dialog.findViewById(R.id.emailId);
        final EditText amountt = dialog.findViewById(R.id.amountt);
        final EditText other = dialog.findViewById(R.id.other);
        Button update = dialog.findViewById(R.id.update);

        final Global_Access global_access = Global_Access.getInstance();
        fullname.setText(global_access.getName());
        mobile.setText(global_access.getMobilenumber());
        emailId.setText(global_access.getEmail());
        amountt.setText(global_access.getAmount());
        other.setText(global_access.getOthers());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = global_access.getId();
                String name = fullname.getText().toString();
                String mobileNumber = mobile.getText().toString();
                String amount = amountt.getText().toString();
                String email = emailId.getText().toString();
                String others = other.getText().toString();
                if(name.isEmpty()&&mobileNumber.isEmpty()&&amount.isEmpty()&&email.isEmpty()&&others.isEmpty())
                {
                    Toast.makeText(context,"Enter Fields",Toast.LENGTH_LONG).show();
                }else {
                    dbHelper.updateContact(i+1,name,mobileNumber,amount,email,others);
                    dialog.dismiss();
                }
            }
        });
    }

    private void delete(final int i) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.delete_layout);
        dialog.setCancelable(true);
        dialog.show();
        Button yes  =  dialog.findViewById(R.id.yes);
        Button no   =  dialog.findViewById(R.id.no);
        TextView text = dialog.findViewById(R.id.text);
        text.setText("Are Want Delete this Record");
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteContact(i+1);
                dialog.dismiss();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.details_adapter,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        try {
            String name = registrationVos.get(position).getName();
            String mobile = registrationVos.get(position).getMobilenumber();
            String amount = registrationVos.get(position).getAmount();
            String emailid = registrationVos.get(position).getEmail();
            String other = registrationVos.get(position).getOther();
            if(name!=null&&mobile!=null&&amount!=null)
            {
                holder.names.setText(name);
                holder.ph_number.setText(mobile);
                holder.amount.setText(amount);
                holder.email.setText(emailid);
                holder.otherDeatails.setText(other);
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        //return registrationVos.size();
        return registrationVos.size();
    }

}
