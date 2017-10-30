package de.carey.desigggn.app;

public interface Cons {

    String CLIENT_ID = "3542445d22853ca416185b1274bec04d2e74aaeb73b96e06ab0c509b262f9ae2";

    String CLIENT_SECRET = "dde630a4996682ffc2c0bd8c36473d530cd092d16d759708f4d7fb18939b942a";

    String CLIENT_ACCESS_TOKEN = "5dc2d0f99753f94cfe69350b183465b89f3df9e2e0550081e011458c7db1eb3a";

    String REDIRECT_URI = "https://www.google.com/";

    String SCOPE = "public write comment upload";

    String STATE = "hunter";

    String SP_ACCESS_TOKEN = "sp_access_token";

    String SP_VIEW_MODE = "SP_VIEW_MODE";

    int VIEW_MODE_SMALL = 0;

    int VIEW_MODE_LARGE = 1;

    int PAGE_SIZE = 20;

    int SEARCH_PAGE_SIZE = 10;

    /**
     * 类型，默认返回所有类型
     */
    String[] LIST_VALUES = {"", "teams", "debuts", "playoffs", "rebounds", "animated"};
    String[] SELECTOR_TYPE = {"全部", "团队", "首秀", "精品", "再创作", "动画"};

    String TYPE_JSON = "[{\"desc\":\"全部\",\"value\":null},{\"desc\":\"首秀\",\"value\":\"debuts\"},{\"desc\":\"团队\",\"value\":\"teams\"},{\"desc\":\"精品\",\"value\":\"playoffs\"},{\"desc\":\"再创作\",\"value\":\"rebounds\"},{\"desc\":\"动画\",\"value\":\"animated\"},{\"desc\":\"附件\",\"value\":\"attachments\"}]";
    String SORT_JSON = "[{\"desc\":\"最热\",\"value\":null},{\"desc\":\"最新\",\"value\":\"recent\"},{\"desc\":\"浏览最多\",\"value\":\"views\"},{\"desc\":\"评论最多\",\"value\":\"comments\"}]";
    String TIME_JSON = "[{\"desc\":\"当前\",\"value\":null},{\"desc\":\"周\",\"value\":\"week\"},{\"desc\":\"月\",\"value\":\"month\"},{\"desc\":\"年\",\"value\":\"year\"},{\"desc\":\"所有\",\"value\":\"ever\"}]";

    int TIME_OUT_SECONDS = 15;

    interface Url {

        String BASE_URL = "https://api.dribbble.com/v1/";

        String BASE_JSOUP_URL = "https://dribbble.com/";

        String OAUTH_URL = "https://dribbble.com/oauth/";
    }

    interface Path {

        String AUTHORIZE = "authorize";

        String TOKEN = "token";

        String SHOTS = "shots";

        String SHOTS_DETAIL = "shots/{id}";

        String SHOTS_COMMENTS = "shots/{id}/comments";

        String SHOTS_COMMENTS_DETAIL = "shots/{shots}/comments/{id}";

        String SHOTS_PUT_COMMENTS = "/shots/{shot}/comments/{id}";

        String SHOTS_LIKE = "shots/{id}/like";

        String SEARCH = "search";

        String USER = "user";

        String USER_FOLLOWERS = "users/{id}/followers";

        String USER_SHOTS = "users/{id}/shots";

        String USER_BUCKETS = "user/buckets";

        String BUCKETS_DETAIL = "shots/{id}/buckets";

        String ADD_SHOTS_TO_BUCKETS = "buckets/{id}/shots";
    }

    interface Param {

        String CLIENT_ID = "client_id";

        String CLIENT_SECRET = "client_secret";

        String REDIRECT_URI = "redirect_uri";

        String SCOPE = "scope";

        String STATE = "state";

        String CODE = "code";

        String LIST = "list";

        String TIME_FRAME = "timeframe";

        String SORT = "sort";

        String PAGE = "page";

        String PER_PAGE = "per_page";

        String SEARCH_KEY = "q";

        String BODY = "body";

        String SHOTS_ID = "shot_id";
    }
}
