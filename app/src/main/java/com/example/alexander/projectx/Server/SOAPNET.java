 package com.example.alexander.projectx.Server;

 import android.content.Context;
 import android.os.AsyncTask;
 import android.util.Log;

 import com.example.alexander.projectx.util.CMensajeDialog;

 import org.ksoap2.SoapEnvelope;
 import org.ksoap2.serialization.SoapObject;
 import org.ksoap2.serialization.SoapSerializationEnvelope;
 import org.ksoap2.transport.HttpTransportSE;
 import org.xmlpull.v1.XmlPullParserException;

 import java.io.IOException;
 import java.util.concurrent.ExecutionException;

//import org.ksoap2.transport.HttpTransport;

 public class SOAPNET extends AsyncTask<Object[], String, String>{
     private static String SOAP_ACTION = null;
     private static String METHOD_NAME = null;
     private static String NAMESPACE = null;
     private static String URLW = null;
     private static String URL = null;
     private Context c;
     private String Data=null;
     private CMensajeDialog ms;
     private URLConexion UConx;
     private SoapObject r;

     /*private static String SOAP_ACTION1 = "http://tempuri.org/HelloWorld";
      private static String NAMESPACE = "http://tempuri.org/";
      private static String METHOD_NAME1 = "HelloWorld";
      private static String URL = "http://192.168.56.101/webservice_c/Service1.asmx?WSDL";
     */

     public SOAPNET(Context ct, String SOAPA, String METODO, String NAMEWEB, String URL, String WSDL) {
         this.c=ct;
         this.ms=new CMensajeDialog(ct);
         this.SOAP_ACTION=SOAPA;
         this.METHOD_NAME=METODO;
         this.NAMESPACE=NAMEWEB;
         this.URL=URL;
         this.URLW=WSDL;

         UConx=new URLConexion(ct, URL);
         UConx.execute();
     }

     public String getData() throws InterruptedException, ExecutionException {
         return this.get();
     }
     public void setData(String data) {
         Data = data;
     }

     public String setSoap(Object[][] dato)throws RuntimeException, Exception, IOException, XmlPullParserException{
         SoapObject soap=new SoapObject(NAMESPACE, METHOD_NAME);
         for(int f=0;f<dato.length;f++){
             soap.addProperty(dato[f][0].toString(),dato[f][1]);
         }
         //soap.addProperty("nom","jose");
         SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
         envelope.dotNet = true;
         envelope.setOutputSoapObject(soap);

         //soap.addProperty((String)dato[0][0],dato[0][1]);
         //soap.addProperty((String)dato[1][0],dato[1][1]);

         HttpTransportSE HttpTrans=new HttpTransportSE(URLW);
         HttpTrans.call(SOAP_ACTION, envelope);
         SoapObject resultado=(SoapObject)envelope.bodyIn;
         //SoapObject resultado=(SoapObject)envelope.getResponse();

         //final  SoapPrimitive resultado = (SoapPrimitive)envelope.getResponse();

         /*String resultado=null;
         SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);
         //Use this to add parameters
         request.addProperty("nom","jose");
         //Declare the version of the SOAP request
         SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
         envelope.setOutputSoapObject(request);
         envelope.dotNet = true;
         try {
               HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
               //this is the actual part that will call the webservice
               androidHttpTransport.call(SOAP_ACTION1, envelope);
               // Get the SoapResult from the envelope body.
               SoapObject result = (SoapObject)envelope.bodyIn;
               if(result != null)
               {
                     //Get the first property and change the label text
                     resultado=result.getProperty(0).toString();
               }
               else
               {
                     Toast.makeText(c, "No Response",Toast.LENGTH_LONG).show();
               }
         } catch (Exception e) {
               e.printStackTrace();
         }*/

         return resultado.getProperty(0).toString();
     }

     @Override
     protected String doInBackground(Object[]... params) {
         String result="";
     try{
         try {
             //Inicio del URL HILO
             if(UConx.get()==true){				//Hilo del URL
                 result=setSoap(params);			//Metodo de Soap
             }
             else{
                 result="Error no hay Conexi�n";
             }
             //Fin del URL HILO
         }catch(IOException e){
             Log.v("Error", e.getMessage());
             result ="Error: "+e.getMessage();
         }
         catch (XmlPullParserException e) {
             Log.v("Error", e.getMessage());
             result ="Error: "+e.getMessage();
         }

     }catch (Exception e) {
         Log.v("Error", e.getMessage());
         result ="Error: "+e.getMessage();
     }

     return result;
     }

     @Override
     protected void onPreExecute() {
         super.onPreExecute();
         ms.MProgressBarDato();
     }

     @Override
     protected void onPostExecute(String result) {
         super.onPostExecute(result);
         ms.MCloseProgressBarDato(true);
         //Toast.makeText(c, ""+result, Toast.LENGTH_SHORT).show();
     }

 }

