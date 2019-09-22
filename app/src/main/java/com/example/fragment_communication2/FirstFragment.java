package com.example.fragment_communication2;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    FragmentListenerA listener;

    EditText edtdata;
    Button btn_sendata;

    public interface  FragmentListenerA{

        void  Inputasent(CharSequence input);
    }

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_first, container, false);

        edtdata=view.findViewById(R.id.edtData);
        btn_sendata=view.findViewById(R.id.btn_sendata);

        btn_sendata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = edtdata.getText();
                listener.Inputasent(input);

            }
        });

        return view;
    }

    public void UpdateEdittext(CharSequence newText){
        edtdata.setText(newText);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof  FragmentListenerA){
            listener= (FragmentListenerA) context;

        }else{
            throw new RuntimeException(context.toString()+ "must impliment fragment listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}
