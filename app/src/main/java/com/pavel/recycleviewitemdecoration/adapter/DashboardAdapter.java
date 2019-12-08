package com.pavel.recycleviewitemdecoration.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pavel.recycleviewitemdecoration.R;
import com.pavel.recycleviewitemdecoration.pojo.DashboardItems;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.CustomDashboardView> {


    public Context context;
    public onDashboardCallBack onDashboardCallBack;
    public ArrayList<DashboardItems> dashboardItemsArrayList;


    public DashboardAdapter(Context context, ArrayList<DashboardItems> dashboardItemsArrayList) {
        this.context = context;
        this.dashboardItemsArrayList = dashboardItemsArrayList;
        this.onDashboardCallBack = onDashboardCallBack;
    }


    @NonNull
    @Override
    public CustomDashboardView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_dashboard, viewGroup, false);
        return new CustomDashboardView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomDashboardView holder, int position) {
        final DashboardItems dashboardItems = dashboardItemsArrayList.get(position);
        //Glide.with(context.getApplicationContext()).load(dashboardItems.getImageId()).into(holder.itemImage);

        holder.itemImage.setImageResource(dashboardItems.getImageId());

        holder.itemTitle.setText("" + dashboardItems.getTitle());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDashboardCallBack.onDashboardClick(holder.getAdapterPosition(), dashboardItems);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dashboardItemsArrayList.size();
    }

    public class CustomDashboardView extends RecyclerView.ViewHolder {

        @BindView(R.id.item_image)
        ImageView itemImage;

        @BindView(R.id.item_title)
        TextView itemTitle;

        View view;

        public CustomDashboardView(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, itemView);
        }
    }


    public interface onDashboardCallBack {
        void onDashboardClick(int position, DashboardItems dashboardItems);
    }
}
