package com.example.testabbyy.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testabbyy.R;
import com.example.testabbyy.entities.disks.Disk;

import java.util.List;

public class DisksAdapter extends RecyclerView.Adapter<DisksAdapter.DiskViewHolder> {

    private List<Disk> disks;
    private DiskAdapterClickListener clickListener;

    DisksAdapter(List<Disk> disks, DiskAdapterClickListener clickListener){
        this.disks = disks;
        this.clickListener = clickListener;
    }

    class DiskViewHolder extends RecyclerView.ViewHolder {

        TextView diskName;
        TextView subcategoryName;

        public DiskViewHolder(@NonNull View itemView) {
            super(itemView);
            diskName = itemView.findViewById(R.id.name_product);
            subcategoryName = itemView.findViewById(R.id.subcategory_name);
        }

        void bind(int pos){
            final Disk disk = disks.get(pos);
            diskName.setText(disk.getName());
            subcategoryName.setText(disk.getSubcategory());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onItemClick(disk);
                }
            });
        }
    }

    @NonNull
    @Override
    public DisksAdapter.DiskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_card,parent,false);

        return new DiskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiskViewHolder viewHolder, int i) {
       viewHolder.bind(i);
    }


    @Override
    public int getItemCount() {
        return disks.size();
    }
}