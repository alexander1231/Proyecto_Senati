package com.example.alexander.projectx.Server;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.alexander.projectx.util.CMensajeDialog;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConexion extends AsyncTask<String, String, Boolean>{
		private String URLH=null;
		private Context c;
		private CMensajeDialog ms;
		private String Error=null;
		
		public URLConexion(Context ct, String url) {
			this.URLH=url;
			this.c=ct;
			ms=new CMensajeDialog(ct);
		}
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			ms.MProgressBarDato();	
		}
		
		@Override
		protected Boolean doInBackground(String... params) {
			try{
			ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
			 HttpURLConnection urlc=null;
			 NetworkInfo netInfo = cm.getActiveNetworkInfo();
	        if (netInfo != null && netInfo.isConnected()) {
	                URL url = new URL(URLH);
	                urlc = (HttpURLConnection) url.openConnection();
	                urlc.setConnectTimeout(3000);
	                urlc.connect();
	                if (urlc.getResponseCode() == 200){
	                	return true;
	                }
	        }
			} catch (MalformedURLException e) {
	            e.printStackTrace();
	            Error=e.getMessage();
	        } catch (IOException e) {
	            e.printStackTrace();
	            Error=e.getMessage();
	        }
			return false;
		}
		
		@Override
		protected void onPostExecute(Boolean result) {
			super.onPostExecute(result);
			ms.MCloseProgressBarDato(true);
			if(result==true){
				//Toast.makeText(c, "Servidor Conectado", Toast.LENGTH_SHORT).show();
			}else
				Toast.makeText(c, "Error:"+Error, Toast.LENGTH_SHORT).show();
			
		}
}
