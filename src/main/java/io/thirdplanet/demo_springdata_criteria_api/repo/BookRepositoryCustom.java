package io.thirdplanet.demo_springdata_criteria_api.repo;

import java.util.List;

public interface BookRepositoryCustom {
    List findAll(String bookLabel, String authorFamilyName, String authorName);
}