package com.jaime.ml.challenge.models;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = MlChallengeDatabase.NAME, version = MlChallengeDatabase.VERSION)
public class MlChallengeDatabase {
    public static final String NAME = "MyDataBase";

    public static final int VERSION = 1;
}
