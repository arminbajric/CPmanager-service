package com.cpmanager.service.impl;

import com.cpmanager.service.repositories.ReportRepository;
import com.cpmanager.service.repositories.RequestsRepository;
import com.cpmanager.service.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministrationServiceImpl implements AdministrationService {
    @Autowired
    private final ReportRepository reportRepository;
    @Autowired
    private final RequestsRepository requestsRepository;

    public AdministrationServiceImpl(ReportRepository reportRepository, RequestsRepository requestsRepository) {
        this.reportRepository = reportRepository;
        this.requestsRepository = requestsRepository;
    }
}
