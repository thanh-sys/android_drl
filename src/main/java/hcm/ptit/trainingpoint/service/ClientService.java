package hcm.ptit.trainingpoint.service;

import org.springframework.stereotype.Service;

import hcm.ptit.trainingpoint.model.dto.sdi.ClientSdi;

@Service
public interface ClientService {
    Boolean create(ClientSdi sdi);
}