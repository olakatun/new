package com.example.olakatun.journalapp.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity (tablename = "journal")
public class JournalEntry {

    @PrimaryKey(autoGenerate = true)
    private int entryId;
    private int recentEntry;
    private Date updatedTime;
    private String entryDescription;

    @Ignore
    public JournalEntry(String entryDescription, int recentEntry, Date updatedTime){
        this.entryDescription = entryDescription;
        this.recentEntry = recentEntry;
        this.updatedTime = updatedTime;
    }

    public JournalEntry(int entryId,String entryDescription,int recentEntry,Date updatedTime){
        this.entryId = entryId;
        this.entryDescription = entryDescription;
        this.recentEntry = recentEntry;
        this.updatedTime = updatedTime;
    }

    public int getEntryId(){return entryId;}

    public void setEntryId(int entryId){this.entryId = entryId;}

    public String getEntryDescription() {return entryDescription;}

    public void setEntryDescription(String entryDescription) {this.entryDescription = entryDescription; }

    public int getRecentEntry(){return recentEntry;}

    public void setRecentEntry(){this.recentEntry = recentEntry;}

    public Date getUpdatedTime(){return updatedTime;}

    public void setUpdatedTime(){this.updatedTime = updatedTime;}
}
