package com.integra.greeninfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Marketing extends Fragment{

	List<String> crops;
	Spinner spin;
	ImageView image;
	private Integer[] mThumbIds = {
	        R.drawable.wheat8, R.drawable.rice,
	        R.drawable.sugarcane, R.drawable.maize,
	        R.drawable.jute, R.drawable.tea,
	        R.drawable.coffee
	};
	
	String[] costarray={"38","50","300","250","73","400","600"};
	TextView costTxt;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View marketView = inflater.inflate(R.layout.market, container,
				false);
		costTxt=(TextView)marketView.findViewById(R.id.costTxt);
		spin=(Spinner)marketView.findViewById(R.id.cropspinner);
		image=(ImageView)marketView.findViewById(R.id.cropImage);
		String[] cropsArray = getResources().getStringArray(R.array.crop_arrays);
		crops = new ArrayList<String>(Arrays.asList(cropsArray));
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_item, crops);
		spin.setAdapter(dataAdapter);
	spin.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			image.setImageResource(mThumbIds[position]);
			costTxt.setText("Rate Per/Kg: " + costarray[position]);
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}
	});
		return marketView;
	}

}

