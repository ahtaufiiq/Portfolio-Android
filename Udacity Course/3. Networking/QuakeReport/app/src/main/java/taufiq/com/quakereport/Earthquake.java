package taufiq.com.quakereport;

/**
 * Created by taufiq on 15/02/18.
 */

public class Earthquake {

    private String mMagnitude,mPlaceMagnitude,mDateMagnitude;


    public Earthquake(String magnitude,String placeMagnitude,String dateMagnitude){
        mMagnitude  = magnitude;
        mPlaceMagnitude = placeMagnitude;
        mDateMagnitude=dateMagnitude;
    }


    /**
     *
     * @return Magnitude scala Richter
     */
    public String getmMagnitude() {
        return mMagnitude;
    }

    /**
     *
     * @return Place Magnitude
     */
    public String getmPlaceMagnitude(){
        return mPlaceMagnitude;
    }

    /**
     *
     * @return date Magnitude
     */
    public String getmDateMagnitude() {
        return mDateMagnitude;
    }
}
