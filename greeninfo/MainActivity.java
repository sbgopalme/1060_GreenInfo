package com.integra.greeninfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	static String[] values = new String[] { "Weather Report", "Marketing",
			"Shopping", "Videos", "Messenger" };
	static ListView mainLst;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			mainLst = (ListView) rootView.findViewById(R.id.greenInfoList);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(
					getActivity(), android.R.layout.simple_list_item_1, values);
			mainLst.setAdapter(adapter);
			mainLst.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					final FragmentManager fragmentManager = getActivity()
							.getSupportFragmentManager();
					final FragmentTransaction fragmentTransaction = fragmentManager
							.beginTransaction();
					if (position == 2) {
						Fragment shopfrg = new ShoppingFragment();
						fragmentTransaction.replace(R.id.container, shopfrg);
						fragmentTransaction.addToBackStack(null);
						fragmentTransaction.commit();
					} else if (position == 0) {
						Fragment weatherfrg = new WeatherRepFragment();
						fragmentTransaction.replace(R.id.container, weatherfrg);
						fragmentTransaction.addToBackStack(null);
						fragmentTransaction.commit();

					} else if (position == 3) {
						Fragment weatherfrg = new Video();
						fragmentTransaction.replace(R.id.container, weatherfrg);
						fragmentTransaction.addToBackStack(null);
						fragmentTransaction.commit();

					} else if (position == 4) {
						startActivity(new Intent(getActivity(),
								MessengerActivity.class));
					}else if (position == 1) {
						Fragment marketfrg = new Marketing();
						fragmentTransaction.replace(R.id.container, marketfrg);
						fragmentTransaction.addToBackStack(null);
						fragmentTransaction.commit();
					}
				}
			});

			return rootView;
		}
	}

}
