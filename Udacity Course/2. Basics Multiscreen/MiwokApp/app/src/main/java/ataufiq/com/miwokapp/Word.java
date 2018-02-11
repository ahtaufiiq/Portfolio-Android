package ataufiq.com.miwokapp;

/**
 * Created by taufiq on 08/02/18.
 */

public class Word {

    private String mMiwokTranslation,mDefaultTranslation;
    private int mImageResourceId;

    public Word(String miwokTranslationiwok, String defaultTranslation)
    {
        mMiwokTranslation = miwokTranslationiwok;
        mDefaultTranslation = defaultTranslation;
    }

    public Word(String miwokTranslationiwok, String defaultTranslation,int imageResource)
    {
        mMiwokTranslation = miwokTranslationiwok;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId =imageResource;
    }
    public String getmMiwokTranslation(){
        return mMiwokTranslation;
    }

    public String getmDefaultTranslation(){
        return mDefaultTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }
}
