package com.example.olakatun.journalapp.database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface JournalDao {

    @Query("SELECT * FROM journal ORDER BY recentEntry")
    List<JournalEntry> loadAllEntries();

    @Insert
    void insertJournalEntry(JournalEntry journalEntry);

    @Update(onConflict = onConflictStrategy.REPLACE)
    void updateJournalEntry(JournalEntry journalEntry);

    @Delete
    void deleteJournalEntry(JournalEntry journalEntry);
}
