package com.integra.greeninfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class ShoppingFragment extends Fragment {

	Button seller, buyer;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View shopView = inflater.inflate(R.layout.shopfrag, container, false);
		seller = (Button) shopView.findViewById(R.id.sellerBtn);
		buyer = (Button) shopView.findViewById(R.id.buyerBtn);
		final FragmentManager fragmentManager = getActivity()
				.getSupportFragmentManager();
		final FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		seller.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Fragment sellerfrg = new SellerFrag();
				fragmentTransaction.replace(R.id.container, sellerfrg);
				fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();

			}
		});
		buyer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Fragment buyerfrg = new BuyerFrag();
				fragmentTransaction.replace(R.id.container, buyerfrg);
				fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();
			}
		});
		return shopView;
	}

}
