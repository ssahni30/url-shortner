package services;

import core.Exception.ValidationException;

public interface UrlService {
    String getShortenedUrl(String url, String clientId) throws Exception;

    String getActualUrl(String url);
}
