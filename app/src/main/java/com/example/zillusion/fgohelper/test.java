package com.example.zillusion.fgohelper;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class test extends AppCompatActivity {
    //region TestValue
    private String TAG="---Test---";
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        super.getSupportActionBar().setTitle("Test Region");
        super.getSupportActionBar().setDisplayHomeAsUpEnabled(true);


          //region  Read from the database
          FirebaseFirestore db = FirebaseFirestore.getInstance();
          db.collection("WeekMission")
                  .get()
                  .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                      @Override
                      public void onComplete(@NonNull Task<QuerySnapshot> task) {
                          if (task.isSuccessful()) {
                              for (QueryDocumentSnapshot document : task.getResult()) {
                                  Log.d(TAG, document.getId() + " => " + document.getData());

                              }

                          } else {
                              Log.w(TAG, "Error getting documents.", task.getException());
                          }
                      }
                  });
          //endregion



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {// Backbutton
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here
                Intent intent = new Intent(test.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
