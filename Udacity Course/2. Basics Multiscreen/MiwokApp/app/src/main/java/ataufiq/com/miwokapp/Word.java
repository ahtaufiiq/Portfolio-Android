package ataufiq.com.miwokapp;

/**
 * Created by taufiq on 08/02/18.
 */

public class Word {

    private String mMiwokTranslation,mDefaultTranslation;

    public Word(String mMiwok, String mDefault)
    {
        mMiwokTranslation = mMiwok;
        mDefaultTranslation = mDefault;
    }

    public String getmMiwokTranslation(){
        return mMiwokTranslation;
    }

    public String getmDefaultTranslation(){
        return mDefaultTranslation;
    }
}
