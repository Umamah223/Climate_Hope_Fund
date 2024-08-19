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

public class DonationCardAdapter3 extends RecyclerView.Adapter<DonationCardAdapter3.ViewHolder>{

    DonationCards[] d;

    public DonationCardAdapter3(DonationCards[]d) {
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
    public void onBindViewHolder(@NonNull DonationCardAdapter3.ViewHolder holder, int position) {
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
               "The UAE Food Bank is a charitable organisation, committed to distributing food to those in need while eliminating food waste by collaborating with local authorities as well as local and international " +
                       "charities to create a comprehensive ecosystem to efficiently store, package, and distribute excess fresh food from hotels", "Food For Free improves access to healthy food through establishing innovative programming and partnerships to overcome barriers and strengthen the community food system. We envision a future where everyone in our community – regardless of age, income, " +
                "or ability – has consistent access to fresh, healthy, delicious food." +"Food For Free improves access to healthy food through " +
                "establishing innovative programming and partnerships to overcome barriers "
        };
        return donation_desc[positionOfClick];
    }
    private int getDonationAmount(int positionClicked){
        int[] donation_amnt = {40000,9500};
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
