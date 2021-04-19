package services.impl;

import services.ConfigRepository;

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
