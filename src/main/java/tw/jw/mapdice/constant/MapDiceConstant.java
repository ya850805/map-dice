package tw.jw.mapdice.constant;

public class MapDiceConstant {
    //TODO language
    public static final String NEARBY_SEARCH_URL =
            "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%.4f,%.4f&radius=%.4f&type=%s&opennow=true&language=zh-TW&key=%s";

    public static final String PLACE_DETAIL_URL =
            "https://maps.googleapis.com/maps/api/place/details/json?place_id=%s&language=zh-TW&key=%s";

    public static final String FORGOT_PASSWORD_KEY = "forgot-password-";

    public static final String FORGOT_PASSWORD_TITLE = "Map dice reset password";

    public static final String FORGOT_PASSWORD_CONTENT = "" +
            "<span>親愛的用戶您好</span><br>" +
            "您正在進行<font color='red'>密碼重設</font>操作，<br>" +
            "修改密碼連結為：%s<br>" +
            "此連結<font color='red'>5分鐘</font>有效，請盡快操作謝謝!";
}
