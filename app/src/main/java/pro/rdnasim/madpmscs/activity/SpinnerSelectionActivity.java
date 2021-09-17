package pro.rdnasim.madpmscs.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import pro.rdnasim.madpmscs.R;
import pro.rdnasim.madpmscs.action.ApiCallAction;
import pro.rdnasim.madpmscs.apiservice.ApiService;
import pro.rdnasim.madpmscs.base.BaseActivity;
import pro.rdnasim.madpmscs.model.DivisionDisUpoResponse;
import pro.rdnasim.madpmscs.model.DivisionDisUpoResult;
import pro.rdnasim.madpmscs.model.DivisionsResponse;
import pro.rdnasim.madpmscs.model.DivisionsResult;
import pro.rdnasim.madpmscs.util.UrlLists;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpinnerSelectionActivity extends BaseActivity {

    ApiService apiService;
    Spinner divisionSpinner, districtSpinner, upozillaSpinner;
    Button viewDetails;

    private List<DivisionsResult> divisionsResults = new ArrayList<>();
    private List<DivisionDisUpoResult> divisionDisUpoResults = new ArrayList<>();
    private List<String> upazilla = new ArrayList<>();

    ArrayAdapter<DivisionsResult> fetchDivisionAdapter;
    ArrayAdapter<DivisionDisUpoResult> fetchDivDisUpoAdapter;
    ArrayAdapter<String> fetchUpozillaAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_selection);

        apiService = UrlLists.getApiService();

        //initialize the view
        divisionSpinner = findViewById(R.id.divisionSpinner);
        districtSpinner = findViewById(R.id.districtSpinner);
        upozillaSpinner = findViewById(R.id.upozillaSpinner);

        viewDetails = findViewById(R.id.viewDetails);

        viewDetails.setOnClickListener(v -> {
            Intent intent = new Intent(SpinnerSelectionActivity.this, DivDisUpoDetailsActivity.class);
            startActivity(intent);
        });

        //initialize the all spinner
        divisionSpinnerInit();
        divDisUpoSpinnerInit();
        upozillaSpinnerInit();


        getDivisions(() ->{

            divisionsResults = appStorage.getDivisionsResults();

            fetchDivisionAdapter.clear();
            fetchDivisionAdapter.addAll(divisionsResults);
            fetchDivisionAdapter.notifyDataSetChanged();

            fetchDivDisUpoAdapter.clear();
            fetchDivDisUpoAdapter.notifyDataSetChanged();

            fetchUpozillaAdapter.clear();
            fetchUpozillaAdapter.notifyDataSetChanged();

        });

    }

    private void upozillaSpinnerInit() {
        upazilla = appStorage.getUpazilla();
        fetchUpozillaAdapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_item, upazilla);
        upozillaSpinner.setAdapter(fetchUpozillaAdapter);

        upozillaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               String upozillaName = parent.getItemAtPosition(position).toString();

               //appStorage.setUpozillahName(upozillaName);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void divDisUpoSpinnerInit() {
        divisionDisUpoResults = appStorage.getDivisionDisUpoResults();
        fetchDivDisUpoAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, divisionDisUpoResults);
        districtSpinner.setAdapter(fetchDivDisUpoAdapter);

        districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                DivisionDisUpoResult divisionDisUpoResult = divisionDisUpoResults.get(position);

                appStorage.setUpazilla(divisionDisUpoResult.getUpazilla());
                appStorage.setCoordinate(divisionDisUpoResult.getCoordinates());
                appStorage.setDistrict(divisionDisUpoResult.getDistrict());
                appStorage.setUpozillahName(String.valueOf(divisionDisUpoResult.getUpazilla()));



                upozillaSpinnerInit();

                /*getDivDisUpos(appStorage.getDivisionName(), () -> {

                });*/

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void divisionSpinnerInit() {
        divisionsResults = appStorage.getDivisionsResults();
        fetchDivisionAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, divisionsResults);
        divisionSpinner.setAdapter(fetchDivisionAdapter);

        divisionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                DivisionsResult divisionsResult = divisionsResults.get(position);
                String divisionName = divisionsResult.getDivision();
                appStorage.setDivisionName(divisionName);

                fetchUpozillaAdapter.clear();
                fetchUpozillaAdapter.notifyDataSetChanged();

                getDivDisUpos(divisionName, () -> {

                    divisionDisUpoResults = appStorage.getDivisionDisUpoResults();

                    fetchDivDisUpoAdapter.clear();
                    fetchDivDisUpoAdapter.addAll(divisionDisUpoResults);
                    fetchDivDisUpoAdapter.notifyDataSetChanged();


                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void getDivDisUpos(String divisionName, ApiCallAction apiCallAction){
        Call<DivisionDisUpoResponse> call = apiService.getDivDisUpos(divisionName);
        call.enqueue(new Callback<DivisionDisUpoResponse>() {
            @Override
            public void onResponse(Call<DivisionDisUpoResponse> call, Response<DivisionDisUpoResponse> response) {
                if (response.isSuccessful()){
                    DivisionDisUpoResponse divisionDisUpoResponse = response.body();

                    if (divisionDisUpoResponse != null && divisionDisUpoResponse.getStatus().getMessage().equals("ok")) {
                        divisionDisUpoResults = divisionDisUpoResponse.getData();
                        Log.d("data", divisionDisUpoResults.toString());
                        appStorage.setDivisionDisUpoResults(divisionDisUpoResults);


                        apiCallAction.onSuccess();
                        /*String[] oneUpozilla = new String[divisionDisUpoResults.size()];

                        for (int i = 0; i < divisionDisUpoResults.size(); i++) {
                            oneUpozilla[i] = String.valueOf(divisionDisUpoResults.get(i).getUpazilla());
                        }

                        upozillaSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, oneUpozilla));*/


                    }
                }
            }

            @Override
            public void onFailure(Call<DivisionDisUpoResponse> call, Throwable t) {

            }
        });
    }

    private void getDivisions(ApiCallAction apiCallAction) {

        Call<DivisionsResponse> call = apiService.getDivisions();
        call.enqueue(new Callback<DivisionsResponse>() {
            @Override
            public void onResponse(@NotNull Call<DivisionsResponse> call, @NotNull Response<DivisionsResponse> response) {
                if (response.isSuccessful()) {

                    DivisionsResponse divisionsResponse = response.body();

                    if (divisionsResponse != null && divisionsResponse.getStatus().getMessage().equals("ok")) {
                        divisionsResults = divisionsResponse.getData();
                        appStorage.setDivisionsResults(divisionsResults);


                        //Log.d("data", divisionsResults.toString());
                        apiCallAction.onSuccess();

                    }
                }

            }

            @Override
            public void onFailure(Call<DivisionsResponse> call, Throwable t) {

            }
        });
    }

}