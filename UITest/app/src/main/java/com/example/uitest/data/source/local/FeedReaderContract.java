package com.example.uitest.data.source.local;

import android.provider.BaseColumns;

public class FeedReaderContract {

    public static abstract class TaskEntry implements BaseColumns {
        public static final String TABLE_NAME = "tasks";
        public static final String COLUMN_NAME_ENTRY_ID = "taskid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DETAILS = "details";
    }
}
