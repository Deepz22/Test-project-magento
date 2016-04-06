package com.example.subhashvaikunth.testproject2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * Created by srinivas1 on 2/3/2016.
 */
public class ADPTItems extends BaseAdapter {

    private List<MODELItem> itemList;

    private Context         context;

    OnItemSelected itemSelectedCallBack;


    public interface  OnItemSelected {

        void onSelected(MODELItem modelItem);
    }

    public ADPTItems(Context context, List<MODELItem> itemList, OnItemSelected onItemSelected) {
        this.context = context;
        this.itemList = itemList;

        this.itemSelectedCallBack = onItemSelected;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.grid_item, null);
            holder = new ViewHolder();
            holder.uiRLMain = (RelativeLayout) convertView.findViewById(R.id.uiRLMain);
            holder.pb      = (ProgressBar) convertView.findViewById(R.id.pb);
            holder.uiIV    = (ImageView) convertView.findViewById(R.id.uiIV);
            holder.uiTVName = (TextView) convertView.findViewById(R.id.uiTVName);
            holder.uiTVDob = (TextView) convertView.findViewById(R.id.uiTVDob);
            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();

        }

        final MODELItem item = (MODELItem) getItem(position);
        ImgViewAndPath imgViewAndPath = new ImgViewAndPath();

        imgViewAndPath.setImageView(holder.uiIV);
        imgViewAndPath.setPb(holder.pb);

        imgViewAndPath.setPath(item.getValue());

        new BitmapTask().execute(imgViewAndPath);
        holder.uiTVName.setText(item.getName());
        holder.uiTVDob.setText(item.getPrice());

//        holder.uiRLMain.setTag(position);
        holder.uiRLMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (itemSelectedCallBack != null) {
                    itemSelectedCallBack.onSelected(item);
                }
            }
        });

        return convertView;
    }


    public class BitmapTask extends AsyncTask<ImgViewAndPath, Bitmap, Bitmap> {

        ImageView img = null;
        ProgressBar pb = null;
        String path = null;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            img.setVisibility(View.GONE);
//            pb.setVisibility(View.VISIBLE);

        }

        @Override
        protected Bitmap doInBackground(ImgViewAndPath... params) {

            img = (ImageView) params[0].getImageView();
            pb  = (ProgressBar) params[0].getPb();
            path = (String) params[0].getPath();

            return getBitmapDownloaded(path);
        }


        private Bitmap getBitmapDownloaded(String value) {
            Bitmap bitmap = null;
            try {

                bitmap = BitmapFactory.decodeStream((new FileInputStream(new File(value))));
//                bitmap = getResizedBitmap(bitmap, 50, 50);
//                bitmap = BitmapFactory.decodeStream((InputStream) new URL(url)
//                        .getContent());
                return bitmap;
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;

        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            pb.setVisibility(View.GONE);
            img.setVisibility(View.VISIBLE);
            img.setImageBitmap(bitmap);
        }
    }

    private static class ViewHolder {
        RelativeLayout uiRLMain;
        ImageView uiIV;
        ProgressBar pb;
        TextView uiTVName;
        TextView uiTVDob;
    }
}
