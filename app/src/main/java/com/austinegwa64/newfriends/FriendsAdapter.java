package com.austinegwa64.newfriends;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.austinegwa64.newfriends.Database.Friend;


import java.util.List;

/**
 * Created by gwaza on 6/23/2018.
 */

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder> {
    Context context;
   List<Friend> friends;

    public FriendsAdapter(Context context, List<Friend> friends) {
        this.context = context;
        this.friends = friends;
    }

    @Override
    public FriendsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View  view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_friend_row, null, false);
        FriendsViewHolder friendsViewHolder = new FriendsViewHolder(view);
        return friendsViewHolder ;
    }


    @Override
    public void onBindViewHolder(FriendsViewHolder holder, int position) {

        holder.friendImage.setImageResource(R.drawable.happy);
        holder.friendName.setText(friends.get(position).getName());
        holder.friendContact.setText(friends.get(position).getContact());
        holder.placeMet.setText(friends.get(position).getPlaceMet());

        holder.setItemClickListener(new FriendItemClick() {
            @Override
            public void onFriendItemClick(View v, int position) {
                // make a toast

                Toast.makeText(context, friends.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return friends.size();
    }

    class FriendsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView friendImage;
        TextView  friendName, friendContact, placeMet;
        FriendItemClick friendItemClick;

        public FriendsViewHolder(View itemView) {
            super(itemView);
            friendImage = itemView.findViewById(R.id.friendImage);
            friendName = itemView.findViewById(R.id.friendName);
            friendContact = itemView.findViewById(R.id.contact);
            placeMet = itemView.findViewById(R.id.friendplaceMet);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            this.friendItemClick.onFriendItemClick(view, getLayoutPosition());

        }

        public  void  setItemClickListener( FriendItemClick friendItemClick){

            this.friendItemClick = friendItemClick;
        }
    }
}
