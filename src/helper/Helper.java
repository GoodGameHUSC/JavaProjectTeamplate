package helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author HunG Date : 2018/06/15
 */
public class Helper {

    /**
     * convert String to date default format is : "yyyy/MM/dd"
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getDateFromString(String date) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        Date rs = f.parse(date);
        return rs;
    }

    /**
     * format like it "yyyy/MM/dd HH:mm:ss
     * @param date
     * @param format like it "
     * @return
     * @throws ParseException
     */
    public static Date getDateFromString(String date, String format) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat(format);
        Date rs = f.parse(date);
        return rs;
    }

    /**
     * validation with rule is : email has more than one . charater and one @
     * character
     * 
     * @param email
     * @return
     */
    public static boolean validateEmail(String email) {
        if (email == null)
            return false;

        int socham = 0;
        int soACong = 0;

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '.')
                socham++;
            else if (email.charAt(i) == '@')
                soACong++;
        }
        if (socham >= 1 && soACong == 1)
            return true;
        return false;
    }

    /**
     * using regular expression more information in :
     * https://www.tutorialspoint.com/java/java_regular_expressions.htm
     * 
     * @param email
     * @param regex
     * @return
     */
    public static boolean validateEmail(String email, String regex) {

        Pattern format = Pattern.compile(regex);
        if (email == null)
            return false;
        if (regex.equals(""))
            format = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher m = format.matcher(email);
        if (m.matches())
            return true;
        return false;
    }

    /**
     * There is an example for valid number In fact, you should change follow
     * problem required
     * 
     * @param db
     * @return
     */
    public static boolean validateNumber(double db) {
        if (db > 0 && db < 100 && (double) Math.round(db * 10) / 10 == db)
            return true;
        return false;
    }

    /**
     * Rules : Only contains numeric and more than 7 character
     * 
     * @param soDienThoai
     * @return
     */
    public static boolean validateSoDienThoai(String soDienThoai) {

        int count = 0;
        for (int i = 0; i < soDienThoai.length(); i++) {
            if ("0123456789".contains(String.format("%c", soDienThoai.charAt(i))))
                count++;
        }
        if (count == soDienThoai.length() && count >= 7)
            return true;
        return false;
    }

    /**
     * Determine a string whether contains a String or not
     * 
     * @param resource
     * @param target
     * @param CASE_INSENSITIVE
     * @return
     */
    public static boolean isContainString(String resource, String target, boolean CASE_INSENSITIVE) {
        if (CASE_INSENSITIVE)
            return resource.contains(target);
        else
            return resource.toLowerCase().contains(target.toLowerCase());
    }

    /**
     * Determine a string whether equal a String or not
     * 
     * @param resource
     * @param target
     * @param CASE_INSENSITIVE
     * @return
     */
    public static boolean isEqualString(String resource, String target, boolean CASE_INSENSITIVE) {
        if (CASE_INSENSITIVE)
            return resource.equals(target);
        else
            return resource.toLowerCase().equals(target.toLowerCase());
    }

}