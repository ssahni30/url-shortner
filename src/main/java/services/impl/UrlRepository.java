package services.impl;

import core.UrlInfo;

public interface UrlRepository {
    String saveUrl(UrlInfo urlInfo) throws Exception;

    String getUrl(String url);
}
