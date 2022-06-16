package com.example.library;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
        import androidx.cardview.widget.CardView;
        import androidx.recyclerview.widget.RecyclerView;

        import com.bumptech.glide.Glide;

        import java.util.ArrayList;

public class coursescontent extends RecyclerView.Adapter<coursescontent.ViewHolder> {

    private ArrayList<contentofallcources> morecontents = new ArrayList<>();

    private Context context;
    public coursescontent(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_more,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtxyz.setText(morecontents.get(position).getName());

        Glide.with(context)
                .asBitmap()
                .load(morecontents.get(position).getImageUrl())
                .into(holder.image);

        holder.viewmorelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, coursesdetails.class);
                intent.putExtra("bookId", morecontents.get(position).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return morecontents.size();
    }

    public void setMorecontents(ArrayList<contentofallcources> morecontents) {
        this.morecontents = morecontents;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtxyz;
        private CardView viewmorelayout;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imagemorecontent);
            txtxyz = itemView.findViewById(R.id.txtviewmorecontent);
            viewmorelayout = itemView.findViewById(R.id.viewmorelayout);
        }
    }
}
