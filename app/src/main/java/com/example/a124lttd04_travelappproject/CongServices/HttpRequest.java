    package com.example.a124lttd04_travelappproject.CongServices;

    import retrofit2.Retrofit;
    import retrofit2.converter.gson.GsonConverterFactory;

    public class HttpRequest {
        private  ApiService service;

        public HttpRequest(){
            service=new Retrofit.Builder()
                    .baseUrl(ApiService.url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService.class);
        }
        public  ApiService callAPI(){
            return service;
        }
    }
