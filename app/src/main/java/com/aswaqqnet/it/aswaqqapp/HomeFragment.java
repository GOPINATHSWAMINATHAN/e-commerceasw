package com.aswaqqnet.it.aswaqqapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    public static View.OnClickListener myOnClickListener;
    public ArrayList image;
    public int discount;
    public ArrayList<String> product_name;
    public ArrayList<String> old_price;
    public ArrayList<String> new_price;
   public HomeFragment()
    {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Button check=(Button).findViewById(R.id.fazalur);
//        check.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getActivity(), ProductDisplay.class));
//            }
//        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        List<HomePojo> data = new ArrayList();
            View v = inflater.inflate(R.layout.intro_recycler, container, false);
            Button check = (Button) v.findViewById(R.id.fazalur);
        ImageView img=(ImageView)v.findViewById(R.id.imgview);
            RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.intro_recycler);
            int numberOfColumns = 2;
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(5), true));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            //   Picasso.with(getActivity()).load("http://i.imgur.com/DvpvklR.png").into();
        new HomeDataRetrieve().execute();
        this.image=new HomePojo().getImage();
        this.discount=50;
        this.product_name=new HomePojo().getProduct_name();
        this.old_price=new HomePojo().getOld_price();
        this.new_price=new HomePojo().getNew_price();

            //Log.e("VALUES FROM FRAGMENT",""+data);
            Toast.makeText(getActivity(),""+data,Toast.LENGTH_LONG).show();
 //data.add(new HomeDataRetrieve().al.get(i), 50,new HomeDataRetrieve().al1.get(i),new HomeDataRetrieve().oldPrice.get(i).toString(),new HomeDataRetrieve().newPrice.get(i).toString());
//            data.add(new HomePojo(R.drawable.logo_one, 40, "Iphone 8 plus 128 GB ", "78000", "70000"));
//            data.add(new HomePojo(R.drawable.logo_one, 90, "SONY xperia is a good phone", "30000", "12000"));
//            data.add(new HomePojo(R.drawable.logo_one, 90, "SONY xperia is a good phone", "30000", "12000"));
//            data.add(new HomePojo(R.drawable.logo_one, 40, "Iphone 8 plus 128 GB ", "78000", "70000"));
//            data.add(new HomePojo(R.drawable.logo_one, 90, "SONY xperia is a good phone", "30000", "12000"));
//            data.add(new HomePojo(R.drawable.logo_one, 90, "SONY xperia is a good phone", "30000", "12000"));
//            data.add(new HomePojo(R.drawable.logo_one, 40, "Iphone 8 plus 128 GB ", "78000", "70000"));
//            data.add(new HomePojo(R.drawable.logo_one, 90, "SONY xperia is a good phone", "30000", "12000"));
//            data.add(new HomePojo(R.drawable.logo  _one, 90, "SONY xperia is a good phone", "30000", "12000"));

            recyclerView.setAdapter(new HomeAdapter(getActivity(),image,discount,product_name,old_price,new_price));
//        check.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getActivity(), ProductDisplay.class));
//            }
//        });
            return v;
        }



    @Override
    public void onResume() {
        super.onResume();

        if(getView() == null){
            return;
        }

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();

        getView().setOnKeyListener(new View.OnKeyListener() {
            int count=0;
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    // handle back button's click listener
                    count++;
                    if(count<2) {
                        Toast.makeText(getActivity(), "Please press again to Exit", Toast.LENGTH_LONG).show();
                        return true;
                    }
                    else
                    {
                        getActivity().finish();
                    }
                }
                return false;
            }
        });
    }
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
               outRect.bottom = spacing; // item bottom
            }
            else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public static class MyOnClickListener implements View.OnClickListener
    {
private Context context;
        public MyOnClickListener(Context context)
        {
            this.context=context;
        }
        @Override
        public void onClick(View view) {

        }
    }


}
