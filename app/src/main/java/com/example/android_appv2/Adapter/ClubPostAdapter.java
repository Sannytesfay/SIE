package com.example.android_appv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_appv2.Model.ClubPostModel;
import com.example.android_appv2.R;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.List;

public class ClubPostAdapter extends RecyclerView.Adapter<ClubPostAdapter.ClubMyHolder> {

    private onItemClickListener listener;

    Context context;
    List<ClubPostModel> clubPostModelList;

    public ClubPostAdapter(Context context, List<ClubPostModel> clubPostModelList) {
        this.context = context;
        this.clubPostModelList = clubPostModelList;
    }

    @NonNull
    @Override
    public ClubMyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.actual_club_item,parent,false);
        return new ClubMyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubMyHolder holder, int position) {

        ClubPostModel postion = clubPostModelList.get(position);
        holder.clubTitle.setText(postion.getpClubTitle());
        holder.clubDescription.setText(postion.getpDescription());



    }

    @Override
    public int getItemCount() {
        return clubPostModelList.size();
    }

    class ClubMyHolder extends RecyclerView.ViewHolder {

        TextView clubTitle, clubDescription;


        public ClubMyHolder(@NonNull View itemView) {
            super(itemView);

            clubTitle = itemView.findViewById(R.id.club_Name);
            clubDescription = itemView.findViewById(R.id.club_Description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAbsoluteAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                      //  listener.onItemClick(getSnapshots().getSnapshot(position),position);
                    }
                }
            });


        }
    }
    public interface onItemClickListener {
        void onItemClick(DocumentSnapshot documentSnapshot,int position);
    }

    public void setonItemClickListener(onItemClickListener listener) {
        this.listener = listener;
    }
}
