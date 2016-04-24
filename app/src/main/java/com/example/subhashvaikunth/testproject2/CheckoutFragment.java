package com.example.subhashvaikunth.testproject2;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUBHASH VAIKUNTH on 4/13/2016.
 */
public class CheckoutFragment extends Fragment implements ADPTItems.OnItemSelected {


        private static final String URL = "http://192.168.1.6/server/rest/V1/";

        GridView gridView;
        ADPTItems adptItems;

        OnGridItemSelected itemSelected;

        @Override
        public void onSelected(MODELItem modelItem) {

            itemSelected.onItemSelected(modelItem);
        }

//    @Override
//    public void onSelected(MODELItem modelItem, Media_gallery_entries media_gallery_entriesItem) {
//        itemSelected.onItemSelected(modelItem);
//        itemSelected.onItemSelected(media_gallery_entriesItem);
//
//    }
//
//    @Override
//    public void onSelected(MODELItem modelItem) {
//
//    }


        public interface  OnGridItemSelected {

            void onItemSelected(MODELItem modelItem);
        }


        public CheckoutFragment() {
            // Required empty public constructor
        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            try {
                itemSelected = (OnGridItemSelected) context;
            } catch (ClassCastException e) {
                throw new ClassCastException(getActivity().toString()
                        + " must implement OnGridItemSelected");
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment



            View view = inflater.inflate(R.layout.fragment_grid, container, false);
            init_UI(view);
            new MyTask().execute(URL);
            return view;
        }


        private void init_UI(View view) {
            gridView = (GridView) view.findViewById(R.id.uiGV);
//        gridView.setOnItemClickListener(onItemClickListener);
        }

    /*GridView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Toast.makeText(getActivity(), " pos : " + position, Toast.LENGTH_LONG).show();
//            itemSelected.onItemSelected(position);
        }
    };*/

        private class MyTask extends AsyncTask<String, String, String> {


            @Override
            protected String doInBackground(String... params) {
                return getJSONObject(params[0]);

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                List<MODELItem> itemList = new ArrayList<>();
//            List<Media_gallery_entries> itemList1 = new ArrayList<>();
//            Map<String,List<Map<String,String>>> itemList = new HashMap<String,List<Map<String,String>>>();

                try {

//                JSONObject jsonObject1 = new JSONObject(s);
//                JSONArray  array = new (JSONArray) object.get("items");
//                int len1 = array.length();
//                for(int j=0;j<len1;j++) {
//                    JSONObject object2 = (JSONObject) array.get(j);

//                    item.setPrice(object.getString("price"));
//                    itemList.add(item);}

                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray jsonArray = (JSONArray) jsonObject.get("items");
                    int len = jsonArray.length();
                    for (int i = 0; i < len; i++) {
                        MODELItem item = new MODELItem();
                        JSONObject object1 = (JSONObject) jsonArray.get(i);
                        JSONArray jsonArray1=object1.getJSONArray("custom_attributes");
                        item.setName(object1.getString("name"));
                        item.setPrice(object1.getString("price"));
                        item.setSku(object1.getString("sku"));
                        for(int j=0;j<jsonArray1.length();j++){
                            MODELItem  item1 = new MODELItem();
                            JSONObject object = (JSONObject)jsonArray1.get(j);
                            item1.setAttribute_code(object.getString("attribute_code"));
                            item1.setValue(object.getString("value"));





                        }


//                    JSONObject jsonObject1 = new JSONObject(s);
//                    JSONArray jsonArray1=(JSONArray)jsonObject1.get("Custom_attributes");
//                    for(int j=0;j<jsonArray1.length();j++){
//                        JSONObject object = (JSONObject)jsonArray1.get(j);
//                        item.setAttribute_code(object.getString("value"));
//                        item.setValue(object.getString("value"));
//                    }
//                    item.setAttribute_code(object1.getString("value"));
                        itemList.add(item);
                    }

//                    item.setAttribute_code(object1.getString("attribute_code"));



                } catch (JSONException e) {
                    e.printStackTrace();
                }


//        } catch (JSONException e1) {
//           e1.printStackTrace();
//            }

//        } catch (JSONException e1) {
//                e1.printStackTrace();
//            }
                adptItems = new ADPTItems(getActivity(), itemList, CheckoutFragment.this);
//            adptItems = new ADPTItems(getActivity(), itemlist1, GridFragment.this);
                gridView.setAdapter(adptItems);
                adptItems.notifyDataSetChanged();



//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
            }


            private String getJSONObject(String path) {

                StringBuilder result = new StringBuilder();
                URLConnection connection;
                InputStream inputStream;


                try {

                    java.net.URL url = new URL(path);
                    connection = url.openConnection();
                    inputStream = new BufferedInputStream(connection.getInputStream());

                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

                    String line;

                    while ((line = br.readLine()) != null) {
                        result.append(line);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

                return result != null ? result.toString() : null;
            }


        }}



