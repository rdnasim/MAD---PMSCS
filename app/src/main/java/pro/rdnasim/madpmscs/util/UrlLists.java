package pro.rdnasim.madpmscs.util;

import pro.rdnasim.madpmscs.apiservice.ApiClient;
import pro.rdnasim.madpmscs.apiservice.ApiService;

/**
 * Created by Arif on 10/9/2015.
 */
public class UrlLists {

    public static final String BASE_URL = "https://bdapis.herokuapp.com/api/v1.1/";


    public static ApiService getApiService()
    {
        return  ApiClient.getClient(BASE_URL).create(ApiService.class);
    }

}
