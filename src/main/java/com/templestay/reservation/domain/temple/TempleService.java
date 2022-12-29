package com.templestay.reservation.domain.temple;

import com.templestay.reservation.Crawling;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempleService {

    private static final String TEMPLE_LIST_PAGE = "https://www.templestay.com/temple_search.aspx";
    private final TempleRepository templeRepository;
    private final Crawling crawling = new Crawling(TEMPLE_LIST_PAGE);


    public TempleService(TempleRepository templeRepository) {
        this.templeRepository = templeRepository;
    }

    public void saveAllTempleList() {
        List<Temple> templeList = crawling.initProcess();

        templeRepository.saveAll(templeList);
    }
}
