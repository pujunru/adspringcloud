package me.junrup.projects.service;

import me.junrup.projects.vo.CreativityRequest;
import me.junrup.projects.vo.CreativityResponse;

public interface ICreativityService {
    CreativityResponse createCreativity(CreativityRequest request);
}
