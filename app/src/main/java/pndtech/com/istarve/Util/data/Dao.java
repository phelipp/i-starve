package pndtech.com.istarve.Util.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dao {
    private static Dao instance;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private Dao() {
    }

    public static Dao getInstance() {
        return (instance == null) ? new Dao() : instance;
    }


    public DatabaseReference getDatabaseReference() {
        return (databaseReference == null) ? getFirebaseDatabase().getReference() : databaseReference;
    }

    public FirebaseDatabase getFirebaseDatabase() {
        return (firebaseDatabase == null) ? FirebaseDatabase.getInstance() : firebaseDatabase;
    }
}
