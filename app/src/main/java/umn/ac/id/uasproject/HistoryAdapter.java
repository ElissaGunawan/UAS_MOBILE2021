package umn.ac.id.uasproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.firebase.ui.firestore.paging.LoadingState;
import com.google.firebase.firestore.DocumentSnapshot;

public class HistoryAdapter extends FirestorePagingAdapter<HistoryModel, HistoryAdapter.HistoryViewHolder> {
    private OnClickedHistory onClickedHistory;
    Context mcontext;

    public HistoryAdapter(@NonNull FirestorePagingOptions<HistoryModel> options, OnClickedHistory onClickedHistory) {
        super(options);
        this.onClickedHistory = onClickedHistory;
    }

    @Override
    protected void onBindViewHolder(@NonNull HistoryViewHolder holder, int position, @NonNull HistoryModel model) {
        holder.tdate.setText(model.getDate());
        holder.customer_id.setText(model.getCustomer_id());
        holder.tnominal.setText(model.getPayment());
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_list, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    protected void onLoadingStateChanged(@NonNull LoadingState state) {
        super.onLoadingStateChanged(state);
        switch (state){
            case LOADING_INITIAL:
                Log.d("Paging Log", "Loading Initial Data");
                break;
            case LOADED:
                Log.d("Paging Log", "Total Data Loaded : " + getItemCount());
                break;
            case LOADING_MORE:
                Log.d("Paging Log", "Loading More Data");
                break;
            case FINISHED:
                Log.d("Paging Log", "Loaded All Data");
                break;
            case ERROR:
                Log.d("Paging Log", "Error Loading");
                break;
        }
    }

    public class HistoryViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tdate, customer_id, tnominal;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tdate = itemView.findViewById(R.id.tdate);
            customer_id = itemView.findViewById(R.id.customer_id);
            tnominal = itemView.findViewById(R.id.tnominal);
        }

        @Override
        public void onClick(View v) {
            onClickedHistory.onItemClick(getItem(getAdapterPosition()), getAdapterPosition());
        }
    }

    public interface OnClickedHistory{
        void onItemClick(DocumentSnapshot snapshot, int position);
    }
}
