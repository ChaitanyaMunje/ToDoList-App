package com.chaitanyamunje.assignmenttask;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

class TaskRepository {


    private Dao dao;
    private LiveData<List<Model>> allTasks;

    public TaskRepository(Application application) {
        TaskDatabase database = TaskDatabase.getInstance(application);
        dao = database.Dao();
        allTasks = dao.getAllTasks();
    }

    public void insert(Model model) {
        new InsertNoteAsyncTask(dao).execute(model);
    }

    public void update(Model model) {
        new UpdateNoteAsyncTask(dao).execute(model);
    }

    public void delete(Model model) {
        new DeleteNoteAsyncTask(dao).execute(model);
    }

    public void deleteAllNotes() {
        new DeleteAllNotesAsyncTask(dao).execute();
    }

    public LiveData<List<Model>> getAllTasks() {
        return allTasks;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Model, Void, Void> {
        private Dao dao;

        private InsertNoteAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Model... model) {
            dao.insert(model[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Model, Void, Void> {
        private Dao dao;

        private UpdateNoteAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Model... models) {
            dao.update(models[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Model, Void, Void> {
        private Dao dao;

        private DeleteNoteAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Model... models) {
            dao.delete(models[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {
        private Dao dao;

        private DeleteAllNotesAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deletealltasks();
            return null;
        }
    }
}
