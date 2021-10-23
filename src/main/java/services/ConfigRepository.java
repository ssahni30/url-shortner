package services;

public interface ConfigRepository {
    int getKeyLength();

    /**
     * TODO: Functionality needs to be completed
     * @return expiry in days for a given key
     */
    int getExpiryDays();

}
