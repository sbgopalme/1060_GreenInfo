package com.integra.greeninfo;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GreenInfoDB extends SQLiteOpenHelper{

	private static final String DBNAME="productdb.sqlite";
	private static final String PRODUCTTABLE = "greenproduct";
	private static final String PRODUCT_ID = "prod_id";
	private static final String NAME="name";
	private static final String MOBILE="mobile";
	private static final String PRODUCT="product";
	private static final String RATE="rate";
	SQLiteDatabase sql;
	
	public GreenInfoDB(Context context) {
		super(context, DBNAME, null, 1);
		// TODO Auto-generated constructor stub
	}

	public GreenInfoDB open() throws SQLException {
		sql = this.getWritableDatabase();
		return this;
	}

	public void close() {
		sql.close();
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_TABLE="create table " + PRODUCTTABLE + "(" + PRODUCT_ID + " integer primary key autoincrement, " + NAME + " text, " + MOBILE + " text, " + PRODUCT + " text, " + RATE + " text " + ")" ;
		db.execSQL(CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + PRODUCTTABLE);
	}

	public void insertProductDet(String Name, String mobile,String Product,String Rate) {

		ContentValues val = new ContentValues();
		val.put(NAME, Name);
		val.put(MOBILE, mobile);
		val.put(PRODUCT, Product);
		val.put(RATE, Rate);
		sql.insert(PRODUCTTABLE, null, val);
	}
	
	public List<Product> getRecord(String det){
		List<Product> Namelist = new ArrayList<Product>();
		String selectQuery = " SELECT * FROM " + PRODUCTTABLE + " WHERE "	+ NAME + " like '"  +  det  +  "'" +  " or  " +  MOBILE + " like '"  +  det  +  "'" +  " or  " +  PRODUCT + " like '"  +  det  +  "'" +  " or  " +  RATE + " like '"  +  det  +  "'";
		Cursor cursor = sql.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				
				Product nm = new Product();
				nm.setProdname(cursor.getString(1));
				nm.setProdmobile(cursor.getString(2));
				nm.setProduct(cursor.getString(3));
				nm.setProdrate(cursor.getString(4));
				Namelist.add(nm);
			} while (cursor.moveToNext());
	}
		
		return Namelist;
	}
	
	public boolean checkProductt(String product) {
		
		Cursor c = sql.rawQuery(" SELECT * FROM " + PRODUCTTABLE + " WHERE "	+ NAME + " like '"  +  product  +  "'" +  " or  " +  MOBILE + " like '"  +  product  +  "'" +  " or  " +  PRODUCT + " like '"  +  product  +  "'" +  " or  " +  RATE + " like '"  +  product  +  "'", null);
		if (c != null && c.getCount() > 0) {
			return true;
			/* record exist */
		} else {
			return false;
			/* record not exist */
		}
	}
	
}
