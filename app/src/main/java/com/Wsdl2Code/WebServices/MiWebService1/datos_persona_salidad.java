package com.Wsdl2Code.WebServices.MiWebService1;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.5
//
// Date Of Creation: 4/27/2015 3:18:20 AM
//    Please dont change this code, regeneration will override your changes
//</wsdl2code-generated>
//
//------------------------------------------------------------------------------
//
//This source code was auto-generated by Wsdl2Code  Version
//
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import java.util.Hashtable;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class datos_persona_salidad implements KvmSerializable {
    
    public String mensaje;
    
    public datos_persona_salidad(){}
    
    public datos_persona_salidad(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("mensaje"))
        {
            Object obj = soapObject.getProperty("mensaje");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                mensaje = j.toString();
            }else if (obj!= null && obj instanceof String){
                mensaje = (String) obj;
            }
        }
    }
    @Override
    public Object getProperty(int arg0) {
        switch(arg0){
            case 0:
                return mensaje;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 1;
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch(index){
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "mensaje";
                break;
        }
    }

    @Override
    public String getInnerText() {
        return null;
    }

    @Override
    public void setInnerText(String s) {

    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}
