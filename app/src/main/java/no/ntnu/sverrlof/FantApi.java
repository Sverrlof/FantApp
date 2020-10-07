package no.ntnu.sverrlof;

import no.ntnu.sverrlof.fragment.RegisterFragment;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface FantApi {

    @FormUrlEncoded
    @POST("auth/create")
    public Call<ResponseBody> createUser(@Field("email") String email,
                                         @Field("uid") String username,
                                         @Field("pwd") String password);

    @GET("auth/login")
    public Call<ResponseBody> userLogin(@Field("uid") String username,
                                        @Field("pwd") String password);

}
