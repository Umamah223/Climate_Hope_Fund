package com.example.climatehopefund_trial1;

import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class cardAdapter extends RecyclerView.Adapter<cardAdapter.ViewHolder> {
//CardAdapter class
//    View Holder : VolunteerOrgHolder2
//  declaring the array
VolunteerOrgCards[] v;

    public cardAdapter(VolunteerOrgCards[] v) {
        this.v = v;
    }
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView cv = (CardView) inflater.inflate(R.layout.item_cards_volunteer,parent,false);
        return new ViewHolder(cv);

}
    @Override
    public void onBindViewHolder(@NonNull cardAdapter.ViewHolder holder, int position) {
        CardView cv = holder.cardView;
        ImageView volunteer_org_img = cv.findViewById(R.id.volunteer_org_img);
        TextView name_volunteer_org = cv.findViewById(R.id.name_volunteer_org);
        TextView volunteer_info = cv.findViewById(R.id.volunteer_info);
        TextView know_more_volunteer_org = cv.findViewById(R.id.know_more_volunteer_org);


        VolunteerOrgCards volunteerOrgCards = v[position];

        volunteer_org_img.setImageResource(volunteerOrgCards.getVolunteer_img());
        name_volunteer_org.setText(volunteerOrgCards.getVolunteer_org_name());
        volunteer_info.setText(volunteerOrgCards.getInfo_volunteer());
        know_more_volunteer_org.setText(volunteerOrgCards.getKnow_more());


        // Set an OnClickListener for the entire card
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedPosition = holder.getAdapterPosition();

                Intent i = new Intent(v.getContext(), volunteer_organizations_sample.class);
                i.putExtra("NAME_VOLUNTEER_sample", volunteerOrgCards.getVolunteer_org_name());
                i.putExtra("VOLUNTEER_IMG", volunteerOrgCards.getVolunteer_img());
                i.putExtra("VOLUNTEER_DESC", getDescrOrg(clickedPosition));
                i.putExtra("ORG_NAME",volunteerOrgCards.getVolunteer_org_name());

                i.putExtra("VOLUNTEER_CATG_1", volunteerOrgCards.getVolunteer_category_1());
                i.putExtra("VOLUNTEER_CATG_2", volunteerOrgCards.getVolunteer_category_2());


//  Getting the volunteer_category info checking error
                Log.d("ImageDebug", "Category1: " + volunteerOrgCards.getVolunteer_category_1() + ", Category2: " + volunteerOrgCards.getVolunteer_category_2());

                v.getContext().startActivity(i);

//// Moving to another activity when the user clicks on a volunteer category image
//                Intent i1 = new Intent(v.getContext(), VolunteerCategoryInfo.class);
//                i1.putExtra("VOLUNTEER_CATEGORY_TITLE",volunteerOrgCards.getVolunteer_category_title());
//                i1.putExtra("VOLUNTEER_CATEGORY_LOCATION", volunteerOrgCards.getVolunteer_category_location());
//                i1.putExtra("VOLUNTEER_NOW_BTN", volunteerOrgCards.getVolunteerButton().getText().toString());
//
//                v.getContext().startActivity(i1);
            }
        });
    }

    // Changing the description according to organization
    private String getDescrOrg(int position) {
        String[] org_desc = {
                "Through the BEEAH Recycling vertical, BEEAH Group has developed a self-sustaining model for the management of waste and zero-waste strategies. " +
                        "The company has made great headway " + "towards a zero-waste solution." + "Volunteer Now",
                "EEG is a professional working group devoted to protecting the environment through " +
                        "the means of education, action programmes and community involvement."+ "Volunteer With us Now."
        };
        return org_desc[position];
    }

    @Override
    public int getItemCount() {
        return v.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
    }
}
}
