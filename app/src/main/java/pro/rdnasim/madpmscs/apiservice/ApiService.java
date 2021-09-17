package pro.rdnasim.madpmscs.apiservice;

import java.util.List;

import pro.rdnasim.madpmscs.model.DivisionDisUpoResponse;
import pro.rdnasim.madpmscs.model.DivisionsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("divisions")
    Call<DivisionsResponse> getDivisions();

    @GET("division/{division}")
    Call<DivisionDisUpoResponse> getDivDisUpos(
            @Path("division") String division
    );

}
