package com.chaitanyamunje.assignmenttask;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private TaskRepository repository;
    private LiveData<List<Model>> allTasks;
    public ViewModel(@NonNull Application application) {
        super(application);
        repository=new TaskRepository(application);
        allTasks=repository.getAllTasks();
    }



    public void insert(Model model) {
        repository.insert(model);
    }
    public void update(Model model) {
        repository.update(model);
    }
    public void delete(Model model) {
        repository.delete(model);
    }
    public void deleteAllTasks() {
        repository.deleteAllNotes();
    }
    public LiveData<List<Model>> getAllTasks() {
        return allTasks;
    }
}
