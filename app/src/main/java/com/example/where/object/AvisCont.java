package com.example.where.object;

import android.provider.BaseColumns;

public class AvisCont {

    private AvisCont(){}

    public static final class AvisEntry implements BaseColumns{
        public static final String TABLE_NAME = "memories";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_IMAGE = "image";

    }


}
