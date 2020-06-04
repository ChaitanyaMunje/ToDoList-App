package com.chaitanyamunje.assignmenttask;

import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insert(Model model);
    @Update
    void update(Model note);
    @Delete
    void delete(Model model);

    @Query("DELETE FROM task_table")
    void deletealltasks();

    @Query("SELECT * FROM task_table ORDER BY priority ASC")
    LiveData<List<Model>> getAllTasks();
}
