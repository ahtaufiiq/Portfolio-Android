package taufiq.com.quakereport;

/**
 * Created by taufiq on 15/02/18.
 */

public class Earthquake {

    private String mMagnitude,mPlaceMagnitude;

    private long mTimeInMilliseconds;


    public Earthquake(String magnitude,String placeMagnitude,long timeInMilliseconds){
        mMagnitude  = magnitude;
        mPlaceMagnitude = placeMagnitude;
        mTimeInMilliseconds=timeInMilliseconds;
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
    public long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
