package com.example.climatehopefund_trial1;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PreferredDonationAdapter extends RecyclerView.Adapter<PreferredDonationAdapter.ViewHolder> {
    List<PreferredDonationCards> preferredDonationCardsList;

   public PreferredDonationAdapter(List<PreferredDonationCards> preferredDonationCardsList){
       this.preferredDonationCardsList = preferredDonationCardsList;
   }

    @NonNull
    @Override
    public PreferredDonationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView cvD = (CardView) inflater.inflate(R.layout.activity_items_cards_donations,parent,false);
        return new PreferredDonationAdapter.ViewHolder(cvD);
    }

    @Override
    public void onBindViewHolder(@NonNull PreferredDonationAdapter.ViewHolder holder, int position) {
        CardView cvD = holder.cardview1;
        ImageView donation_org_img = cvD.findViewById(R.id.donation_org_img);
        TextView name_donation_org = cvD.findViewById(R.id.name_donation_org);
        CheckBox checkbox = cvD.findViewById(R.id.checkbox_favourite_Donations);

        PreferredDonationCards preferredDonationCards = preferredDonationCardsList.get(position);

        donation_org_img.setImageResource(preferredDonationCards.getImage());

        // Set other views
        name_donation_org.setText(preferredDonationCards.getOrganizationName());


//        PreferredDonationCards preferredDonationCards = preferredDonationCardsList.get(position);
//        PreferredDonationCards preferredDonationCards = new PreferredDonationCards(
//                R.drawable.plant_a_tree_eeg,
//                "Emirates Environmental Group",
//                "Donate Now",
//                "-->");

//        Glide.with(holder.itemView.getContext())
//                .load(preferredDonationCards.getImageUrl())
//                .into(donation_org_img);


        checkbox.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if(!isChecked){
                Toast.makeText(holder.itemView.getContext(),"Removed from Preferred Donations",Toast.LENGTH_SHORT).show();
                preferredDonationCardsList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,preferredDonationCardsList.size());
            }
        }) );

    }

    @Override
    public int getItemCount() {
        return  preferredDonationCardsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardview1;
        CheckBox checkbox;

        public ViewHolder(CardView d) {
            super(d);
            cardview1 = d;
            checkbox = d.findViewById(R.id.checkbox_favourite_Donations);
        }
    }
}
