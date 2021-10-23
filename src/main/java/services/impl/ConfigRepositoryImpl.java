package services.impl;

import services.ConfigRepository;

/**
 * This is Dummy class to keep all types of config required for application.
 */
public class ConfigRepositoryImpl implements ConfigRepository {
    @Override
    public int getKeyLength() {
        return 8;
    }

    @Override
    public int getExpiryDays() {
        return 30;
    }
}
