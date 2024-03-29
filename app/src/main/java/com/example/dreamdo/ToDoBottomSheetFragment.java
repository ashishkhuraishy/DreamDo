package com.example.dreamdo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;


public class ToDoBottomSheetFragment extends BottomSheetDialogFragment {

    private TextInputEditText inputText;
    private MaterialButton button;
    private FragmentListener listener;


    public interface FragmentListener{
        void OnInputInterface(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_to_do, container, false);

        inputText = v.findViewById(R.id.input);
        button = v.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = inputText.getText();
                listener.OnInputInterface(input);
                dismiss();
            }
        });

        return  v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            listener = (FragmentListener) context;
        }else {
            throw new RuntimeException(context.toString()
            + " must implement FragmentListner");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
