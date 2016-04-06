package com.example.subhashvaikunth.testproject2;

import android.app.ListFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;


public class CartListFragment extends android.support.v4.app.ListFragment implements ADPTList.UpdateCart {


    List<String> cartList;

    UpdateCartList mCallBack;
    ADPTList adptList;

    public interface  UpdateCartList {
        void updateCartList(String name);
    }

    public CartListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        cartList = bundle.getStringArrayList("LIST");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       /* ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, cartList);

        setListAdapter(adapter);
//        getListView().setOnItemClickListener(this);*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart_list, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adptList = new ADPTList(getActivity(), cartList, this);
        getListView().setAdapter(adptList);
        adptList.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallBack = (UpdateCartList) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement UpdateCartList");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void removeFromCart(String name) {
        mCallBack.updateCartList(name);
    }
}

