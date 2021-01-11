package com.example.recycler82;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler82.databinding.WordItemListBinding;

import java.util.List;
//3.extender de recycler.adapter pasando el View
//4.
public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.WordViewHolder> {

    //añadimos una lista de String que contendra los datos
    private List<String> mWordList;

    public WordsAdapter(List<String> mWordList) {
        this.mWordList = mWordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //6. instanciamos View
        WordItemListBinding mBinding = WordItemListBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new WordViewHolder(mBinding);
    }
    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String word = mWordList.get(position);
        holder.textView.setText(word);
    }
    @Override
    public int getItemCount() {
        //5. indicar que retorna el tamaño del listado
        return mWordList.size();
    }


    //2.crear clase interna llamada xxxViewHolder
    public class WordViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public WordViewHolder(@NonNull WordItemListBinding mBinding) {
            super(mBinding.getRoot());
            textView = mBinding.textView;
        }


    }

}
