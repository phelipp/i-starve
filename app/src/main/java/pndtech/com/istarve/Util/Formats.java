package pndtech.com.istarve.Util;

import android.telephony.PhoneNumberUtils;

import java.text.NumberFormat;
import java.util.Locale;

import pndtech.com.istarve.Data.information.Phone;

public class Formats {
    static public String currency(float value)
    {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        return numberFormat.format(value);
    }
    static  public  String phone(Phone phone){
       return PhoneNumberUtils.formatNumber(phone.getDdd()+phone.getNumberPhone(), Locale.getDefault().getCountry());
    }
}
