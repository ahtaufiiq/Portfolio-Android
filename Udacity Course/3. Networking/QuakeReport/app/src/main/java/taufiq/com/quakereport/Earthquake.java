package taufiq.com.quakereport;

/**
 * Created by taufiq on 15/02/18.
 */

public class Earthquake {

    private double mMagnitude;
    private String mPlaceMagnitude;

    private long mTimeInMilliseconds;


    public Earthquake(double magnitude,String placeMagnitude,long timeInMilliseconds){
        mMagnitude  = magnitude;
        mPlaceMagnitude = placeMagnitude;
        mTimeInMilliseconds=timeInMilliseconds;
    }


    /**
     *
     * @return Magnitude scala Richter
     */
    public double getmMagnitude() {
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
