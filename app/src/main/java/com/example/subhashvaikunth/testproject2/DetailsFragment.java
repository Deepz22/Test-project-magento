package com.example.subhashvaikunth.testproject2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;





public class DetailsFragment extends Fragment implements View.OnClickListener{

    private ImageView img;
    private TextView  des;
    //    private Button    add;
//    private Button    remove;
    private ProgressBar pb;

    private MODELItem item;



//    CartUpdate mCallBack;

   /* public interface CartUpdate {

        void addToCart(MODELItem item);
        void removeFromCart(MODELItem item);
    }*/

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        item = (MODELItem) bundle.getSerializable("ITEM");
//        item1=(Media_gallery_entries) bundle.getSerializable("ITEM1");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*try {
            mCallBack = (CartUpdate) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnGridItemSelected");
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        init_UI(view);
        return view;
    }


    private void init_UI(View view) {

        img = (ImageView) view.findViewById(R.id.uiIVPic);
        pb  = (ProgressBar) view.findViewById(R.id.uiPb);
        des  = (TextView) view.findViewById(R.id.uiTVDes);
//        add  = (Button)  view.findViewById(R.id.uiBtnADD);
//        remove  = (Button)  view.findViewById(R.id.uiBtnRM);
//        add.setOnClickListener(this);
//        remove.setOnClickListener(this);

        if (item != null) {
            String path = item.getValue();
            String name = item.getName();
            des.setText(name);
            ImgViewAndPath viewAndPath = new ImgViewAndPath();
            viewAndPath.setImageView(img);
            viewAndPath.setPb(pb);
           viewAndPath.setPath(path);
            new BitmapTask().execute(viewAndPath);
        }
    }

    @Override
    public void onClick(View v) {
        /*switch (v.getId()) {
            case R.id.uiBtnADD:
                mCallBack.addToCart(item);
                break;
            case R.id.uiBtnRM:
                mCallBack.removeFromCart(item);
            break;
        }*/

    }


    public class BitmapTask extends AsyncTask<ImgViewAndPath, Bitmap, Bitmap> {

        private String path = null;
        private ProgressBar pb = null;
        private ImageView img = null;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(ImgViewAndPath... params) {
           ImgViewAndPath imgViewAndPath = params[0];
            img = (ImageView) params[0].getImageView();
            pb  = (ProgressBar) params[0].getPb();
            path = (String) params[0].getPath();
            return getBitmapDownloaded(path);
        }

        private Bitmap getBitmapDownloaded(String value) {
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeStream((new FileInputStream(new File(value))));
//                bitmap = BitmapFactory.decodeStream((InputStream) new URL(url)
//                        .getContent());
                return bitmap;
            } catch (Exception e) {
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
}

