package tw.jw.mapdice.service;

import tw.jw.mapdice.domain.Place;

import java.util.List;

public interface PlaceService {
    Integer insert(Place place);
    List<Place> findByIds(List<String> placeIds);
}
