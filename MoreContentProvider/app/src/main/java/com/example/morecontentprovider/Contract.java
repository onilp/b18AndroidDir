package com.example.morecontentprovider;

import android.net.Uri;

public class Contract {
    private Contract(){

    }

    public static final String AUTHORITY = "com.example.minicontentprovider.provider";
    public static final String CONTENT_PATH = "words"; //table name

    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH);

    static final int ALL_ITEMS = -2;
    final String WORD_ID = "id";

    static final String SINGLE_RECORD_MIME_TYPE = "vnd.android.cursor.item/vnd.com.eample.provider.words";
    static final String MULTIPLE_RECORD_MIME_TYPE = "vnd.android.cursor.dir/vnd.com.example.provider.words";


}
