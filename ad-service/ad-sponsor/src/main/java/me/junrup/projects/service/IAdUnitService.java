package me.junrup.projects.service;

import me.junrup.projects.exception.AdException;
import me.junrup.projects.vo.*;

public interface IAdUnitService {

    AdUnitResponse createUnit(AdUnitRequest request)
            throws AdException;

    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request)
            throws AdException;

    AdUnitInterestResponse createUnitInterest(AdUnitInterestRequest request)
            throws AdException;

    AdUnitLocationResponse createUnitLocation(AdUnitLocationRequest request)
            throws AdException;

    CreativityUnitResponse createCreativityUnit(CreativityUnitRequest request)
            throws AdException;
}
