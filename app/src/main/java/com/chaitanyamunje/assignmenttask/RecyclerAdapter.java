package com.chaitanyamunje.assignmenttask;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends ListAdapter<Model,RecyclerAdapter.ViewHolder> {
    private OnItemClickListener listener;

    RecyclerAdapter() {
        super(DIFF_CALLBACK);

    }


    private static final DiffUtil.ItemCallback<Model> DIFF_CALLBACK = new DiffUtil.ItemCallback<Model>() {
        @Override
        public boolean areItemsTheSame(Model oldItem, Model newItem) {
            return oldItem.getId() == newItem.getId();
        }
        @Override
        public boolean areContentsTheSame(Model oldItem, Model newItem) {
            return oldItem.getTask_name().equals(newItem.getTask_name()) &&
                    oldItem.getDescription().equals(newItem.getDescription()) &&
                    oldItem.getStatus().equals(newItem.getStatus());
        }
    };

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        Model model=getTaskAt(position);
        holder.task_name.setText(model.getTask_name());
        holder.task_prio.setText(""+model.getPriority());
        holder.task_status.setText(model.getStatus());
    }

    public Model getTaskAt(int position) {
        return getItem(position);
    }
    public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView task_name,task_status,task_prio;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            task_name=itemView.findViewById(R.id.task_name);
            task_status=itemView.findViewById(R.id.status);
            task_prio=itemView.findViewById(R.id.task_priority);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });

        }
    }

    public interface OnItemClickListener {
        void onItemClick(Model model);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
