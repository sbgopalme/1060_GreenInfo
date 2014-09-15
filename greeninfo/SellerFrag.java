package com.integra.greeninfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SellerFrag extends Fragment{

	EditText nmeedt,mobedt,prodedt,rateedt;
	Button done;
	GreenInfoDB db;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View sellerView = inflater.inflate(R.layout.sellerfrag, container,
				false);
		db= new GreenInfoDB(getActivity());
		db.open();
		nmeedt=(EditText)sellerView.findViewById(R.id.NameEdt);
		mobedt=(EditText)sellerView.findViewById(R.id.MobileEdt);
		prodedt=(EditText)sellerView.findViewById(R.id.ProductEdt);
		rateedt=(EditText)sellerView.findViewById(R.id.rateEdt);
		done=(Button)sellerView.findViewById(R.id.dneBtn);
		done.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(isValid()){
					db.insertProductDet(nmeedt.getText().toString(), mobedt.getText().toString(), prodedt.getText().toString(), rateedt.getText().toString());
					Toast.makeText(getActivity(), "Product Saved", Toast.LENGTH_SHORT).show();
					nmeedt.setText("");
					mobedt.setText("");
					prodedt.setText("");
					rateedt.setText("");
				}else{
					Toast.makeText(getActivity(), "Fields are Empty", Toast.LENGTH_SHORT).show();
				}
			}
		});
		return sellerView;
	}
	private boolean isValid() {
		boolean isValidFlag = true;
		try {
			if(isEmpty(nmeedt.getText().toString())){
				isValidFlag = false;
			}else if(isEmpty(mobedt.getText().toString())){
				isValidFlag = false;
			}else if(isEmpty(prodedt.getText().toString())){
				isValidFlag = false;
			}else if(isEmpty(rateedt.getText().toString())){
				isValidFlag = false;
			}
		} catch (Exception ex) {
			isValidFlag = false;

		}
		return isValidFlag;
	}
	
	public static boolean isEmpty(String param) {
		boolean isEmpty = false;
		try {
			isEmpty = param.trim().length() == 0 ? true : false;
		} catch (Exception ex) {
			isEmpty = true;
		}
		return isEmpty;
	}

}
