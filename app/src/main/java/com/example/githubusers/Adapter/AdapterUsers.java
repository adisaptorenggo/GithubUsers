package com.example.githubusers.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.githubusers.Model.User;
import com.example.githubusers.R;

import java.io.InputStream;
import java.util.List;

public class AdapterUsers extends RecyclerView.Adapter<AdapterUsers.MyViewHolder> {
    List<User> mUsersList;

    public AdapterUsers(List<User> UsersList) {
        mUsersList = UsersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        new DownloadImageTask(holder.mImageViewUser)
                .execute(mUsersList.get(position).getAvatar_url());
        holder.mTextViewUser.setText(mUsersList.get(position).getLogin());
    }

    @Override
    public int getItemCount () {
        return mUsersList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageViewUser;
        public TextView mTextViewUser;

        public MyViewHolder(View itemView) {
            super(itemView);
//            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mImageViewUser = itemView.findViewById(R.id.ivUser);
            mTextViewUser = itemView.findViewById(R.id.tvUser);
        }
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
