package de.carey.desigggn.api;

import java.util.List;

import de.carey.desigggn.app.Cons;
import de.carey.desigggn.entity.CommentEntity;
import de.carey.desigggn.entity.ShotEntity;
import de.carey.desigggn.entity.TokenEntity;
import de.carey.desigggn.entity.UserEntity;
import io.reactivex.Flowable;

public class NetRepository {

    private NetRepository() {

    }

    private static class SingletonHolder {
        static NetRepository INSTANCE = new NetRepository();
    }

    public static NetRepository get() {
        return SingletonHolder.INSTANCE;
    }

    public Flowable<TokenEntity> getAccessToken(String code) {
        return ApiClient.getOAuthStore()
                .getToken(Cons.CLIENT_ID, Cons.CLIENT_SECRET, code, Cons.REDIRECT_URI);
    }

    public Flowable<UserEntity> getUserInfo() {
        return ApiClient.getRestStore().getUserInfo();
    }

    public Flowable<List<ShotEntity>> getShotsList(String type, String sort, String timeFrame,
                                                   int pageIndex, int pageSize) {
        return ApiClient.getRestStore().getShotsList(type, sort, timeFrame, pageIndex, pageSize);
    }

    public Flowable<List<CommentEntity>> getComments(String url) {
        return ApiClient.getRestStore().getComments(url);
    }
}
