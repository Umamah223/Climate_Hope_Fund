package com.example.climatehopefund_trial1;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class DonationCardAdapter1 extends RecyclerView.Adapter<DonationCardAdapter1.ViewHolder>{
    DonationCards[] d;
    OnItemClickListener onItemClickListener;
    CollectionReference store_Image;
    FirebaseAuth auth;

    public DonationCardAdapter1(DonationCards[]d,OnItemClickListener onItemClickListener,CollectionReference store_Image){
        this.d = d;
        this.onItemClickListener = onItemClickListener;
        this.store_Image = store_Image;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView cvD = (CardView) inflater.inflate(R.layout.activity_items_cards_donations,parent,false);
        return new ViewHolder(cvD);

    }

    @Override
    public void onBindViewHolder(@NonNull DonationCardAdapter1.ViewHolder holder, int position) {
        CardView cvD = holder.cardview1;

        ImageView donation_org_img = cvD.findViewById(R.id.donation_org_img);
        TextView name_donation_org = cvD.findViewById(R.id.name_donation_org);
        TextView donation_info = cvD.findViewById(R.id.donation_info);
        TextView know_more_donation_org = cvD.findViewById(R.id.know_more_donation_org);
        CheckBox checkBoxDonation = cvD.findViewById(R.id.checkbox_favourite_Donations);

        DonationCards donationCards = d[position];

        donation_org_img.setImageResource(donationCards.getDonation_img());
        name_donation_org.setText(donationCards.getDonation_org_name());
        donation_info.setText(donationCards.getInfo_donation());
        know_more_donation_org.setText(donationCards.getKnow_more_donation());

        auth = FirebaseAuth.getInstance();

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

        //adding/removing items to wishlist or preferred Donations
        Log.d("Adapter", "onBindViewHolder: Position: " + position);
        if (checkBoxDonation != null) {
            checkBoxDonation.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    Log.d("Adapter", "onCheckedChanged: Checked at position " + position);
                    StoreImageCloud(cvD,holder.getAdapterPosition());
                    addToPreferredDonations(holder.getAdapterPosition());
                    Toast.makeText(holder.itemView.getContext(), "Added to Preferred Donations", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

//Method to add items to Preferred Donations/WishList
    private void addToPreferredDonations(int position) {
        if (auth.getCurrentUser() != null){

          DatabaseReference userReference = FirebaseDatabase.getInstance().getReference("Users").child("Donations");
          userReference.addListenerForSingleValueEvent(new ValueEventListener() {
              @Override
              public void onDataChange(@NonNull DataSnapshot snapshot) {
                  if(snapshot.exists()){
                      for (DataSnapshot donations : snapshot.getChildren()){
                          String organization_Name = donations.child("organizationDonatedTo").getValue(String.class);
                          String user_id = donations.child("userId").getValue(String.class);

                          //Getting images from Firebase Cloud Storage
                          FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
                          StorageReference storage = firebaseStorage.getReference().child("images/donation/image_" +position +".png");

                          storage.getDownloadUrl().addOnSuccessListener(uri -> {
                              FirebaseFirestore firestore = FirebaseFirestore.getInstance();
                              DocumentReference documentDonationsReference = firestore.collection("Preferred Donations").document(user_id);

                              Map<String,Object> data = new HashMap<>();
                              data.put("organizationDonatedTo",organization_Name);
                              data.put("Url_Image",storage.getDownloadUrl().toString());

                              documentDonationsReference.set(data).addOnSuccessListener(aVoid -> {
                                  Log.d("Firestore","Data added to Preferred Donations");
                              }).addOnFailureListener(e -> {
                                  Log.e("Firestore", "Failed to add data to Preferred Donations", e);
                              });

                              String donationid = donations.getKey();
                              Log.d("RealTime db","Donation ID :"+ donationid);

                          });

                          String donationid = donations.getKey();
                          Log.d("Realtime database", "Donation ID: " + donationid);

                          break;
                      }
                  }
              }
              @Override
              public void onCancelled(@NonNull DatabaseError error) {
                  Log.e("Realtime Database", "Error reading data", error.toException());
              }
          });
//              organizationDonatedName.child("organizationDonatedTo").addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot snapshot) {
//                    if(snapshot.exists()){
//
//                        String organizationDonatedName = snapshot.child("Donations").child("organizationDonatedTo").getValue(String.class);
//                        Log.d("Firestore", "Organization Name Before Firestore: " + organizationDonatedName);
//
//                        CollectionReference images = FirebaseFirestore.getInstance().collection("Images");
//
//                        images.document("Donation" +position).get().addOnCompleteListener(task -> {
//                            if (task.isSuccessful() && task.getResult() != null){
//                                DocumentSnapshot documentSnapshot = task.getResult();
//
//                                Long imageIdLong = documentSnapshot.getLong("imageId");
//                                int imageId = imageIdLong!= null? imageIdLong.intValue() : 0;
//
//
//                                Log.d("Firestore", "Organization Name: " + organizationDonatedName);
//
//                            }
//                            else{
//                                Log.e("Firestore", "Error getting document", task.getException());
//                            }
//                        });
//                    }
//                    else{
//                        Log.e("Firestore", "Snapshot does not exist");
//                    }
//                }
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//                }
//            });
        }
    }

    private Object convertToBase(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    public void StoreImageCloud(View v, int positionOfClick) {
        DonationCards donationCards = d[positionOfClick];

        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
        StorageReference storageReference = firebaseStorage.getReference().child("images/donation/image_" + positionOfClick + ".png");
        Log.d("Storage", "Storage Reference Path: " + storageReference.getPath());

        Bitmap images = BitmapFactory.decodeResource(v.getResources(),donationCards.getDonation_img());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        images.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        byte[] images_data = outputStream.toByteArray();

        UploadTask upload = storageReference.putBytes(images_data);

//        upload.addOnSuccessListener(taskSnapshot -> {
//            Toast.makeText(v.getContext(),"Image Stored in Cloud Storage",Toast.LENGTH_LONG).show();
//        });
    }
    private String getDonationDesc(int positionOfClick) {
        String [] donation_desc = {
                "At the Emirates Environmental Group , we believe in the power of action to create a sustainable future . Make a difference by contributing to Donate to Plant a Tree  where your generosity\n" +
                        "can help us reach our goal of planting thousands of trees. " +
                        "Your contributions help in fostering a greener planet.\n" +
                        "every donation counts, with contributions up to 50,000 dirhams","Through the Tree-Nation platform we aim to bring a technological solution to the problem of deforestation, " +
                "responsible for about 17% of all climate change emissions.\n" +
                "We want to use technology to make tree planting easy and provide support,"
        };
        return donation_desc[positionOfClick];
    }

    private int getDonationAmount(int positionOfClick){
        int[] donation_amnt = {50000,65000};
        return donation_amnt[positionOfClick];
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    @Override
    public int getItemCount() {
        return d.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardview1;
        CheckBox checkBoxDonation;
        public ViewHolder(CardView d) {
            super(d);
            cardview1 = d;
            checkBoxDonation = d.findViewById(R.id.checkbox_favourite_Donations);
        }
    }
}


//    private boolean isInWishlist(int position){
//        return preferredDonationList[position];
//    }
//
//    private void addToWishlistItem(int position){
//        preferredDonationList[position] = true;
//        notifyDataSetChanged();
//    }
//    private void removeFromWishlistItem(int position){
//        preferredDonationList[position] = false;
//        notifyDataSetChanged();
//    }

    //method to show menu
//    private void showMenu(View anchorView, int position){
//        PopupMenu donationMenu = new PopupMenu(anchorView.getContext(), anchorView);
//        MenuInflater inflater = donationMenu.getMenuInflater();
//        inflater.inflate(R.menu.preferred_donations_menu, donationMenu.getMenu());
//
//        // set the menu based on the items in the preferred donations
//        MenuItem addToWishlistItem = donationMenu.getMenu().findItem(R.id.preferred_donations_add);
//        MenuItem removeFromWishlistItem = donationMenu.getMenu().findItem(R.id.preferred_donations_remove);
//
//        addToWishlistItem.setVisible(!isInWishlist(position));
//        removeFromWishlistItem.setVisible(isInWishlist(position));

//        donationMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                int itemId = item.getItemId();
//                if (itemId == R.id.preferred_donations_add) {
//                    addToWishlistItem(position);
//                    return true;
//                } else if (itemId == R.id.preferred_donations_remove) {
//                    removeFromWishlistItem(position);
//                    return true;
//                }
//                return false;
//            }
//        });
//
//        donationMenu.show();

//        ListPopupWindow listPopupWindow = new ListPopupWindow(anchorView.getContext());
//        listPopupWindow.setAnchorView(anchorView);
//        listPopupWindow.setAdapter(new ArrayAdapter<>(anchorView.getContext(), android.R.layout.simple_list_item_1));
//        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                donationMenu.show();
//                listPopupWindow.dismiss();
//            }
//        });
//        listPopupWindow.show();
//    }

    //method to show menu


//         if (isInWishlist(position)) {
//             removeFromWishlistItem.setVisible(true);
//             addToWishlistItem.setVisible(false);
//         } else {
//             removeFromWishlistItem.setVisible(false);
//             addToWishlistItem.setVisible(true);
//         }

