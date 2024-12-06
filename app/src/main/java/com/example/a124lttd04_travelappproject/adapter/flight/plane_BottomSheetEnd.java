package com.example.a124lttd04_travelappproject.adapter.flight;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.a124lttd04_travelappproject.model.flight.NoidenModel;
import com.example.a124lttd04_travelappproject.model.flight.NoidiModel;
import com.example.a124lttd04_travelappproject.model.flight.Response;
import com.example.a124lttd04_travelappproject.view.flight.plane_VeMayBay_Activity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class plane_BottomSheetEnd extends BottomSheetDialogFragment {
    private LinearLayout linearLayout;
    private HttpRequest httpRequest;

    private plane_VeMayBay_Activity vemaybay;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plane_bottom_sheet_end_location, container, false);
        linearLayout = view.findViewById(R.id.Sheetend);
        httpRequest = new HttpRequest();
        ApiService apiService = httpRequest.callAPI();

        apiService.getNoidenList().enqueue(new Callback<Response<List<NoidenModel>>>() {
            @Override
            public void onResponse(Call<Response<List<NoidenModel>>> call, retrofit2.Response<Response<List<NoidenModel>>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Response<List<NoidenModel>> apiResponse = response.body();
                    if (response.body().getStatus() == 200) {
                        List<NoidenModel> noidenList = apiResponse.getData();
                        populateNoidenList(noidenList); // Implement this method to update your UI
                    } else {
                        Toast.makeText(requireContext(), "Error: " + apiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(requireContext(), "Failed to fetch data: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Response<List<NoidenModel>>> call, Throwable t) {
                Toast.makeText(requireContext(), "Network Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }



    private void populateNoidenList(List<NoidenModel> noidenList) {
        linearLayout.removeAllViews(); // Clear existing views
        for (NoidenModel noiden : noidenList) {
            TextView textView = new TextView(requireContext());
            textView.setText(noiden.getNoiden()); // Display only the `noidi`
            textView.setTextSize(20);
            textView.setPadding(0,0,0,15);
            textView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            // Set OnClickListener to handle clicks
            textView.setOnClickListener(v -> {
                // Get the clicked noiden value
                String selectedNoiden = noiden.getNoiden();

                Intent intent = new Intent(requireContext(), plane_VeMayBay_Activity.class);
                intent.putExtra("selected_noiden", selectedNoiden); // Pass the noiden value
                startActivity(intent); // Start the activity

            });


            linearLayout.addView(textView); // Add TextView to LinearLayout
        }
    }
}
