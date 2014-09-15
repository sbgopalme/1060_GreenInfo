package com.integra.greeninfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Video extends Fragment{

	ListView videolst;
	String[] videos={"Video1","Video2","Video3","Video4"};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View video = inflater.inflate(R.layout.video, container,
				false);
		videolst=(ListView)video.findViewById(R.id.videolst);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, videos);
		videolst.setAdapter(adapter);
		videolst.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				final FragmentManager fragmentManager = getActivity()
						.getSupportFragmentManager();
				final FragmentTransaction fragmentTransaction = fragmentManager
						.beginTransaction();
				Bundle arguments = new Bundle();
			    arguments.putInt("id_position", position);
				Fragment marketfrg = new VideoFrag();
				marketfrg.setArguments(arguments);
				fragmentTransaction.replace(R.id.container, marketfrg);
				fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();
			}
		});
		return video;
	}

}
