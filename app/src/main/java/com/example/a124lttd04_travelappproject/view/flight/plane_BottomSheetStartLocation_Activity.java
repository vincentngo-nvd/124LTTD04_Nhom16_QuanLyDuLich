package com.example.a124lttd04_travelappproject.view.flight;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a124lttd04_travelappproject.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class plane_BottomSheetStartLocation_Activity extends BottomSheetDialogFragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.plane_bottom_sheet_start_location, container, false);

        EditText searchEditText = view.findViewById(R.id.searchEditText);
        Button cancelButton = view.findViewById(R.id.cancelButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        return view;
    }
}
