package com.integra.greeninfo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuyerFrag extends Fragment{

	EditText searchEdit;
	Button search;
	GreenInfoDB db;
	List<Product> prodarray = new ArrayList<Product>();
	String display;
	TextView disTxt;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View buyerView = inflater.inflate(R.layout.buyerfrag, container,
				false);
		db= new GreenInfoDB(getActivity());
		db.open();
		searchEdit=(EditText)buyerView.findViewById(R.id.searchEdt);
		disTxt=(TextView)buyerView.findViewById(R.id.searchresult);
		search=(Button)buyerView.findViewById(R.id.searchBtn);
		search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(db.checkProductt(searchEdit.getText().toString())){
					prodarray=db.getRecord(searchEdit.getText().toString());
					
					display =  String.valueOf(prodarray.get(0).getProdname()) + " "  + String.valueOf(prodarray.get(0).getProdmobile()) + " "  + String.valueOf(prodarray.get(0).getProduct()) + " "  + String.valueOf(prodarray.get(0).getProdrate());
					disTxt.setText(display);
				}else{
					Toast.makeText(getActivity(), "Product Doesn't Exsists", Toast.LENGTH_SHORT).show();
				}
			}
		});
		return buyerView;
	}

}
