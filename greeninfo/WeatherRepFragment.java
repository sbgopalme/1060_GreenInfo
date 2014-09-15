package com.integra.greeninfo;

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

public class WeatherRepFragment extends Fragment{

	String[] weatherarray={"Erode","Salem","namakkal","coimbatore","Tiruppur","Nagapattinam","Theni"};
	Spinner spin;
	TextView weather;
	String[] reportarray={"32","33","23","18","19","22","33"};
	ImageView climateimg;
	private Integer[] mThumbIds = {
	        R.drawable.sunnyy, R.drawable.cloudy,
	        R.drawable.thunder, R.drawable.rainy,
	        R.drawable.rainy, R.drawable.thunder,
	        R.drawable.sunnyy
	};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View weatherrepView = inflater.inflate(R.layout.weatherreport, container,
				false);
		climateimg=(ImageView)weatherrepView.findViewById(R.id.weatherimage);
		weather= (TextView)weatherrepView.findViewById(R.id.locationReport);
		spin=(Spinner)weatherrepView.findViewById(R.id.weatherspinner);
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_item, weatherarray);
		spin.setAdapter(dataAdapter);
		spin.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				weather.setText( reportarray[position] + " ¼ C");
				climateimg.setImageResource(mThumbIds[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		return weatherrepView;
	}

}
