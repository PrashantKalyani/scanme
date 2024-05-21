package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Request;
import com.desapex.spacemanager.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public void saveRequest(Request request) {
        if (request.getSentby() == null || request.getReceivedby() == null || request.getTaskid() == null || request.getReferenceid() == null || request.getAssetdata()== null) {
            throw new IllegalArgumentException("Invalid request data");
        }

        if (request.getDate() == null) {
            request.setDate(new Date());
        }
        requestRepository.save(request);
    }

    public List<Request> getRequestsByReceivedby(String receivedBy) {
        return requestRepository.findByReceivedby(receivedBy);
    }
}