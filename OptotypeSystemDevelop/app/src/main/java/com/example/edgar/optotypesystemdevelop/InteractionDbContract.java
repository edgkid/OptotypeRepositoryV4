package com.example.edgar.optotypesystemdevelop;

import android.provider.BaseColumns;

/**
 * Created by Edgar on 27/10/2017.
 */

public class InteractionDbContract {

    public static abstract class InteractionEntry implements BaseColumns{

        public static final String TABLE_NAME = "interaction_db_app";

        public static final String ID = "idInterection";
        public static final String IDOPTOTYPE = "idOptotype";
        public static final String IDPATIENT = "idPatient";
        public static final String OPTOTYPECODE = "optotypeCode";

    }

}
