package tw.jw.mapdice.constant;

public class MapDiceConstant {
    //TODO language
    public static final String NEARBY_SEARCH_URL =
            "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%.4f,%.4f&radius=%.4f&type=%s&opennow=true&language=zh-TW&key=%s";

    public static final String PLACE_DETAIL_URL =
            "https://maps.googleapis.com/maps/api/place/details/json?place_id=%s&language=zh-TW&key=%s";
}
