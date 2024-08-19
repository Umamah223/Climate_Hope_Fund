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

public class DonationCardAdapter4 extends RecyclerView.Adapter<DonationCardAdapter4.ViewHolder> {
    DonationCards[] d;

    public DonationCardAdapter4(DonationCards[]d){
        this.d = d;
    }


    @NonNull
    @Override
    public DonationCardAdapter4.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView cvD = (CardView) inflater.inflate(R.layout.activity_items_cards_donations,parent,false);
        return new ViewHolder(cvD);
    }

    @Override
    public void onBindViewHolder(@NonNull DonationCardAdapter4.ViewHolder holder, int position) {
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
                "Mangrove Education Project is an international nonprofit organization  community-led conservation, focusing on not just the challenges affecting the wetlands but also" +
                        " those of the communities who relied on them." + "It aims to find viable, long-term, equitable solutions to " +
                        "restoring these vital ecosystems. ", "Blue Mangrove is an initiative of Friendship Belgium, a non profit organisation" + "hope to reach our common goal: create a sustainable environment where" +
                " nature and humans come together and live in harmony." + " We work on a voluntary basis and all the funds collected for Blue Mangrove are exclusively allocated to the Mangrove Plantation project. The statutes of Friendship Belgium and the fund budget are available in the Family Room."
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
