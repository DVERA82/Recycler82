package com.example.recycler82;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recycler82.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment<pu> extends Fragment {

    private FragmentFirstBinding mBinding;
    private List<String> listado = new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        mBinding = FragmentFirstBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Instanciamos el adapter y le pasamos el listado de datos
        WordsAdapter mAdapter = new WordsAdapter(wordList());
        mBinding.rv.setAdapter(mAdapter);
        mBinding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

        public void onClick() {


            listado.add("palabra" + listado.size());
            mBinding.rv.getAdapter().notifyItemInserted(listado.size());
            //scroll al final
            mBinding.rv.smoothScrollToPosition(listado.size());

        }

            private List<String> wordList(){
            List<String> listado = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                listado.add("Palabra" + i);
            }
            return listado;
        }

    }