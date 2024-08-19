package com.example.climatehopefund_trial1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DonationCardAdapter2 extends RecyclerView.Adapter<DonationCardAdapter2.ViewHolder> {
    DonationCards[] d;

    public DonationCardAdapter2(DonationCards[]d){
        this.d = d;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView cvD = (CardView) inflater.inflate(R.layout.activity_items_cards_donations,parent,false);
        return new ViewHolder(cvD);
    }

    @Override
    public void onBindViewHolder(@NonNull DonationCardAdapter2.ViewHolder holder, int position) {
        CardView cvD = holder.cardview1;

        ImageView donation_org_img = cvD.findViewById(R.id.donation_org_img);
        TextView name_donation_org = cvD.findViewById(R.id.name_donation_org);
        TextView donation_info = cvD.findViewById(R.id.donation_info);
        TextView know_more_donation_org = cvD.findViewById(R.id.know_more_donation_org);

        DonationCards donationCards = d[position];

        donation_org_img.setImageResource(donationCards.getDonation_img());
        name_donation_org.setText(donationCards.getDonation_org_name());
        donation_info.setText(donationCards.getInfo_donation());
        know_more_donation_org.setText(donationCards.getKnow_more_donation());

// Onclick listener for the Donation cardview
        cvD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position_of_click = holder.getAdapterPosition();

                Intent intents = new Intent(v.getContext(), DonationOrganizationSample.class);
                intents.putExtra("heading_donation_categories_title",donationCards.getDonation_org_name());
                intents.putExtra("imageViewDonation",donationCards.getDonation_img());
                intents.putExtra("description_donation", getDonationDesc(position_of_click));
                intents.putExtra("donation_amount_gathered",getDonationAmount(position_of_click));

                v.getContext().startActivity(intents);

            }
        });
    }
    private String getDonationDesc(int positionOfClick) {
        String [] donation_desc = {
                "Our motto ‘educate, motivate, and activate’ is more than just a tag line, it’s how we achieve success to restore coral reefs, " +
                        "reduce debris, and achieve a healthier ocean. As a volunteer-led organisation, we run activities, " +
                        "workshops and educational events that are focused on awareness and improving biodiversity", "The Emirates Marine Environmental" +
                " Group mission is to preserve biodiversity in the United Arab Emirates Advancing scientific research through collaboration\n" +
                "Promoting environmental education within the local community\n" +
                "Conserving fragile ecosystems for future generations\n"
        };
        return donation_desc[positionOfClick];
    }

    private int getDonationAmount(int positionClicked){
        int[] donation_amnt = {60000,7500};
        return donation_amnt[positionClicked];
    }
    @Override
    public int getItemCount() {
        return d.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardview1;

        public ViewHolder(CardView d){
            super(d);
            cardview1 = d;
        }
    }
}