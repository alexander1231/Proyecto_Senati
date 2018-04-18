package com.example.alexander.projectx.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class CMensajeDialog {
	private Context c;
	private Activity act;
	private AlertDialog.Builder ms;
	private ProgressDialog nDialog=null; 
	private EditText dato;
	private Integer[] Icon={android.R.drawable.ic_delete,
						   android.R.drawable.ic_input_add,
						   android.R.drawable.ic_dialog_alert,
						   android.R.drawable.ic_dialog_email,
						   android.R.drawable.ic_dialog_info,
						   android.R.drawable.ic_input_get,
						   android.R.drawable.ic_menu_delete,
						   android.R.drawable.ic_menu_edit,
						   android.R.drawable.ic_menu_save,
						   android.R.drawable.ic_menu_search};
	
	public EditText getDato() {
		return dato;
	}

	public CMensajeDialog(Context ct, Activity ac) {
		this.c=ct;
		this.act=ac;
		ms=new AlertDialog.Builder(ct);
		nDialog = new ProgressDialog(ct);
	}
	public CMensajeDialog(Context ct) {
		this.c=ct;
		ms=new AlertDialog.Builder(ct);
		nDialog = new ProgressDialog(ct);
	}
	
	public AlertDialog.Builder FMensajeDialog(String t,String m,Object ico){
		ms.setTitle(t);
		ms.setMessage(m);
		ms.setPositiveButton("Aceptar", null);
		
		if(String.valueOf(ico)=="null")ms.setIcon(null);
		else ms.setIcon(Icon[new Integer(ico.toString())]); 
		
		return ms;
	}
	
	public AlertDialog.Builder FMensajeDialogView(String t,String m,Object ico,View v){
		ms.setTitle(t);
		ms.setMessage(m);
		ms.setPositiveButton("Aceptar", null);
		ms.setView(v);
		
		if(String.valueOf(ico)=="null")ms.setIcon(null);
		else ms.setIcon(Icon[new Integer(ico.toString())]); 
		
		return ms;
	}
	
	
	public AlertDialog.Builder FConfirDialog(String t,String m,Object ico){
		ms.setTitle(t);
		ms.setMessage(m);
		
		if(String.valueOf(ico)=="null")ms.setIcon(null);
		else ms.setIcon(Icon[new Integer(ico.toString())]); 
		return ms;
	}
	
	public AlertDialog.Builder FInputDialog(String t,String m,Object ico){
		ms.setTitle(t);
		ms.setMessage(m);
		ms.setCancelable(false);
		dato = new EditText(c);
		ms.setView(dato);
		
		if (String.valueOf(ico) == "null")ms.setIcon(null);
		else ms.setIcon(Icon[new Integer(ico.toString())]);
		return ms;
	}
		
	public AlertDialog.Builder FItemDialog(String t,String[] m,Object ico,OnClickListener Click){
		ms.setTitle(t);
		ms.setItems(m, Click);
		if(String.valueOf(ico)=="null")ms.setIcon(null);
		else ms.setIcon(Icon[new Integer(ico.toString())]); 
		return ms;
	}
	
	public AlertDialog.Builder FItemDialogRadio(String t,String[] m,Object ico,OnClickListener Click){
		ms.setTitle(t);
		ms.setSingleChoiceItems(m, -1, Click);
		if(String.valueOf(ico)=="null")ms.setIcon(null);
		else ms.setIcon(Icon[new Integer(ico.toString())]); 
		return ms;
	}
	
	
	public AlertDialog.Builder FPlataforma(String t,int Loy){
		ms.setTitle(t);  
		LayoutInflater Ly= act.getLayoutInflater();//(LayoutInflater)act.getApplicationContext().getSystemService(c.LAYOUT_INFLATER_SERVICE);
		View v=Ly.inflate(Loy, null);
		ms.setView(v);
		return ms;
	}
	
	public void MProgressBarDato(){
        nDialog.setMessage("Loading..");
        nDialog.setTitle("Conectando..........");
        nDialog.setIndeterminate(false);
        nDialog.setCancelable(true);
        nDialog.show();
    }
	
	public void MClose(Boolean dato){
		if(dato==true){
		//ms.create().cancel();
		ms.create().dismiss();
		//ms.create().closeOptionsMenu();
		}
	}
	public void MCloseProgressBarDato(boolean dato){
		if(dato==true)nDialog.dismiss();
	}
	
}
