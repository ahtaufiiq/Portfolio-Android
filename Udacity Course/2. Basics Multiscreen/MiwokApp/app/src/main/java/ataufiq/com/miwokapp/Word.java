package ataufiq.com.miwokapp;

/**
 * Created by taufiq on 08/02/18.
 */

public class Word {

    private String mMiwokTranslation,mDefaultTranslation;
    private int mImageResourceId=NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED=-1;

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

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
