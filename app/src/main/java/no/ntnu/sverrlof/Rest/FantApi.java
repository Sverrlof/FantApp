package no.ntnu.sverrlof.Rest;

import java.util.List;

import no.ntnu.sverrlof.fragment.RegisterFragment;
import no.ntnu.sverrlof.model.Item;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface FantApi {

    @FormUrlEncoded
    @POST("auth/create")
    public Call<ResponseBody> createUser(@Field("email") String email,
                                         @Field("uid") String username,
                                         @Field("pwd") String password);


    @GET("auth/login")
    public Call<ResponseBody> userLogin(@Query("uid") String username,
                                        @Query("pwd") String password);

    @GET("service/items")
    public Call<List<Item>> getAllItems();


    @FormUrlEncoded
    @POST("service/additem")
    public Call<ResponseBody> addItem(@Header("Authorization") String token,
                                      @Field("item") String item,
                                      @Field("description") String description,
                                      @Field("price") int price);

    @PUT("service/purchase")
    public Call<ResponseBody> purchaseItem(@Header("Authorization") String token,
                                           @Query("iid") Long itemid);

}
