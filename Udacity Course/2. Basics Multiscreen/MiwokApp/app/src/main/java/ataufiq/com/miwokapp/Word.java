package ataufiq.com.miwokapp;

/**
 * Created by taufiq on 08/02/18.
 */

public class Word {

    private String mMiwokTranslation, mDefaultTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    private int mAudioResourceId;

    public Word(String miwokTranslationiwok, String defaultTranslation, int audioResourceId) {
        mMiwokTranslation = miwokTranslationiwok;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String miwokTranslationiwok, String defaultTranslation, int imageResource, int audioResourceId) {
        mMiwokTranslation = miwokTranslationiwok;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResource;
        mAudioResourceId = audioResourceId;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }
}
