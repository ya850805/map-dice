package tw.jw.mapdice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.jw.mapdice.dao.PlaceDao;
import tw.jw.mapdice.domain.Place;
import tw.jw.mapdice.service.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    private PlaceDao dao;

    @Override
    public Integer insert(Place place) {
        if(!dao.exists(place.getId())) {
            dao.insert(place);
            return 1;
        }

        return 0;
    }
}
