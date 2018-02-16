package taufiq.com.quakereport;

/**
 * Created by taufiq on 15/02/18.
 */

public class Earthquake {

    private double mMagnitude;
    private String mPlaceMagnitude,mUrl;

    private long mTimeInMilliseconds;


    public Earthquake(double magnitude, String placeMagnitude, long timeInMilliseconds, String url){
        mMagnitude  = magnitude;
        mPlaceMagnitude = placeMagnitude;
        mTimeInMilliseconds=timeInMilliseconds;
        mUrl=url;
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

    public String getmUrl() {
        return mUrl;
    }
}
