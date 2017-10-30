package de.carey.desigggn.api;

import java.util.List;

import de.carey.desigggn.app.Cons;
import de.carey.desigggn.entity.CommentEntity;
import de.carey.desigggn.entity.ShotEntity;
import de.carey.desigggn.entity.TokenEntity;
import de.carey.desigggn.entity.UserEntity;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

interface ApiStore {

    @POST(Cons.Path.TOKEN)
    Flowable<TokenEntity> getToken(@Query(Cons.Param.CLIENT_ID) String clientId,
                                   @Query(Cons.Param.CLIENT_SECRET) String secret,
                                   @Query(Cons.Param.CODE) String code,
                                   @Query(Cons.Param.REDIRECT_URI) String redirectUri);

    @GET(Cons.Path.USER)
    Flowable<UserEntity> getUserInfo();

    @GET(Cons.Path.SHOTS)
    Flowable<List<ShotEntity>> getShotsList(@Query(Cons.Param.LIST) String type,
                                            @Query(Cons.Param.SORT) String sort,
                                            @Query(Cons.Param.TIME_FRAME) String timeFrame,
                                            @Query(Cons.Param.PAGE) int pageIndex,
                                            @Query(Cons.Param.PER_PAGE) int pageSize);

    @GET
    Flowable<List<CommentEntity>> getComments(@Url String url);
}
