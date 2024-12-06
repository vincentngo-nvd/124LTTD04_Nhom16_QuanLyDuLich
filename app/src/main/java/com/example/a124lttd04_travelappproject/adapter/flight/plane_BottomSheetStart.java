package com.example.a124lttd04_travelappproject.adapter.flight;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a124lttd04_travelappproject.CongServices.ApiService;
import com.example.a124lttd04_travelappproject.CongServices.HttpRequest;
import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.model.flight.NoidiModel;
import com.example.a124lttd04_travelappproject.view.flight.plane_VeMayBay_Activity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import com.example.a124lttd04_travelappproject.model.flight.Response;

public class plane_BottomSheetStart extends BottomSheetDialogFragment {
    private LinearLayout linearLayout;
    private HttpRequest httpRequest;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plane_bottom_sheet_start_location, container, false);
        linearLayout = view.findViewById(R.id.Sheetstart);
        httpRequest = new HttpRequest();
        ApiService apiService = httpRequest.callAPI();

        apiService.getNoidiList().enqueue(new Callback<Response<List<NoidiModel>>>() {
            @Override
            public void onResponse(Call<Response<List<NoidiModel>>> call, retrofit2.Response<Response<List<NoidiModel>>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Response<List<NoidiModel>> apiResponse = response.body();
                    if (response.body().getStatus() == 200) {
                        List<NoidiModel> noidiList = apiResponse.getData();
                        populateNoidiList(noidiList); // Implement this method to update your UI
                    } else {
                        Toast.makeText(requireContext(), "Error: " + apiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(requireContext(), "Failed to fetch data: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Response<List<NoidiModel>>> call, Throwable t) {
                Toast.makeText(requireContext(), "Network Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }



    private void populateNoidiList(List<NoidiModel> noidiList) {
        linearLayout.removeAllViews(); // Clear existing views
        for (NoidiModel noidi : noidiList) {
            TextView textView = new TextView(requireContext());
            textView.setText(noidi.getNoidi()); // Display only the `noidi`
            textView.setTextSize(20);
            textView.setPadding(0,0,0,15);
            textView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            // Set OnClickListener to handle clicks
            textView.setOnClickListener(v -> {
                // Get the clicked noiden value
                String selectedNoidi = noidi.getNoidi();

                Intent intent = new Intent(requireContext(), plane_VeMayBay_Activity.class);
                intent.putExtra("selected_noidi", selectedNoidi); // Pass the noiden value
                startActivity(intent); // Start the activity

            });
            linearLayout.addView(textView); // Add TextView to LinearLayout
        }
    }
}