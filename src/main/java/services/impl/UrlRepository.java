package services.impl;

import core.Exception.ValidationException;
import core.UrlInfo;

public interface UrlRepository {
    String saveUrl(UrlInfo urlInfo) throws ValidationException;

    String getUrl(String url);
}
