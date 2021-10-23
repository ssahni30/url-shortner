package services.impl;

import services.ClientService;

/**
 *   Dummy Service to validate and have client level understanding required for the service
 */
public class ClientServiceImpl implements ClientService {
    @Override
    public boolean verifyClient(String clientId) {
        return true;
    }
}
