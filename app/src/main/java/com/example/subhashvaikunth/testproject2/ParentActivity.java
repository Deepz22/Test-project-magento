package com.example.subhashvaikunth.testproject2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ParentActivity extends FragmentActivity implements GridFragment.OnGridItemSelected, CartListFragment.UpdateCartList,
        View.OnClickListener {




    FrameLayout frameLayout;
    FragmentTransaction transaction;

    private ArrayList<String> cartList = new ArrayList<String>();
//    private int cartSize = 0;

    RelativeLayout uiRLRedbub;
    TextView uiTVNum;
    RelativeLayout uiRLBottom;
    Button uiBtnAdd;
    Button uiBtnRm;

    MODELItem selectedItem;
    RelativeLayout uiRLCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_layout);
        uiRLRedbub = (RelativeLayout) findViewById(R.id.uiRLRedbub);
        uiRLBottom = (RelativeLayout) findViewById(R.id.uiRLBottom);
        uiRLCart   = (RelativeLayout) findViewById(R.id.uiRLCart);

        uiBtnAdd   = (Button) findViewById(R.id.uiBtnADD);
        uiBtnRm    = (Button) findViewById(R.id.uiBtnRM);

        uiRLCart.setOnClickListener(this);
        uiBtnAdd.setOnClickListener(this);
        uiBtnRm.setOnClickListener(this);

        uiTVNum    = (TextView) findViewById(R.id.uiTVNum);
        frameLayout = (FrameLayout) findViewById(R.id.uiFL);
        GridFragment gridFragment = new GridFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.uiFL, gridFragment).commit();
    }


    @Override
    public void onItemSelected(MODELItem item) {
        if (uiRLBottom != null) uiRLBottom.setVisibility(View.VISIBLE);

        selectedItem = item;

        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("ITEM", item);

//        bundle.putString("NAME", item.getName());
//        bundle.putString("URL", item.getImgUrl());
        detailsFragment.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.uiFL, detailsFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (uiRLBottom != null) {
            uiRLBottom.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.uiBtnADD:
                uiRLRedbub.setVisibility(View.VISIBLE);
                if (selectedItem != null) {

                    int listSize = cartList.size();

                    if (!cartList.contains(selectedItem.getName())) {
                        cartList.add(selectedItem.getName());
                        uiTVNum.setText(cartList.size()+"");
                    }

                }
                break;

            case R.id.uiBtnRM:
                if (selectedItem != null) {

                    if (cartList.contains(selectedItem.getName())) {
                        cartList.remove(selectedItem.getName());
                        if (cartList.size() == 0) {
                            uiRLRedbub.setVisibility(View.INVISIBLE);
                        } else {
                            uiTVNum.setText(cartList.size()+"");
                        }
                    }
                }
                break;
            case R.id.uiRLCart:

                CartListFragment listFragment = new CartListFragment();

                Bundle bundle = new Bundle();
                bundle.putStringArrayList("LIST", cartList);

                listFragment.setArguments(bundle);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.uiFL, listFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
        }
    }

    @Override
    public void updateCartList(String name) {

        if (selectedItem != null) {

            if (cartList.contains(selectedItem.getName())) {
                cartList.remove(selectedItem.getName());
                if (cartList.size() == 0) {
                    uiRLRedbub.setVisibility(View.INVISIBLE);
                } else {
                    uiTVNum.setText(cartList.size()+"");
                }
            }
        }
    }
}
