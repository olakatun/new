package com.example.olakatun.journalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.olakatun.journalapp.database.AppDatabase;
import com.example.olakatun.journalapp.database.JournalEntry;

import java.util.Date;

public class AddJournalActivity extends AppCompatActivity {

    //EXTRA for the task ID to be received in the intent
    public static final String EXTRA_ENTRY_ID = "extraEntryId";

    //Extra for the entry Id to be received after rotation.
    public static final String INSTANCE_ENTRY_ID = "instanceEntryId";

    // Constant for recentEntry
    private static final int DEFAULT_ENTRY_ID = -1;

    //Constant for Logging.
    private static final String TAG = AddJournalActivity.class.getSimpleName();

    //Fields for views
    EditText jEditText;
    RadioGroup jRadioGroup;
    Button jButton;

    private int jEntryId = DEFAULT_ENTRY_ID;

    //member variable for the Database
    private AppDatabase jDb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        initViews();

        jDb = AppDatabase.getInstance(getApplicationContext());

        if(savedInstanceState != null && savedInstanceState.containsKey(INSTANCE_ENTRY_ID)) {
            jEntryId = savedInstanceState.getInt(INSTANCE_ENTRY_ID, DEFAULT_ENTRY_ID);
        }

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra(EXTRA_ENTRY_ID)){
            jButton.setText("Update");
            if(jEntryId == DEFAULT_ENTRY_ID){
                //populate the UI
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putInt(INSTANCE_ENTRY_ID,jEntryId);
        super.onSaveInstanceState(outState);
    }

    /**
    * initViews is called to initiate member variable views from within
     * onCreate
     */
    private void initViews(){
        jEditText = findViewById(R.id.editTextEntryDescription);
                             jRadioGroup = findViewById(R.id.radioGroup);

                             jButton = findViewById(R.id.saveButton);
                             jButton.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View view) {
                                     onsaveButonClicked();

                                 }
                             });
    }

    /** call populateUI to populate UI when in update mode
     *
     * @param entry the journalEntry to populate the UI.
     */
    private void populateUI(JournalEntry entry){}

    /**
     * The onSaveButtonClicked is called when the save button is clicked
     * it retrieves and insert the user input into the database
     *
     */
    public void onsaveButonClicked(){
        String journalDescription = jEditText.getText().toString();
        int recentEntry = getRecentEntryFromViews();
        Date date = new Date();

        JournalEntry journalEntry = new JournalEntry(journalDescription, recentEntry, date);
        jDb.journalDao().insertJournalEntry(journalEntry);
        finish();
    }

    /**
     * getRecentEntry is called when the entry needs to be retrieved
     *
     */
    public int getRecentEntryFromViews(){
        int recentEntry = 1;
        int checkedId = ((RadioGroup) findViewById(R.id.radioGroup)).getCheckedRadioButtonId();
        switch (checkedId){

        }
    }


}
