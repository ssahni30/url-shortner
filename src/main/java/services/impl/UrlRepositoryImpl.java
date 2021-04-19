package services.impl;

import core.Exception.ValidationException;
import core.UrlInfo;

import java.util.HashMap;
import java.util.Map;

public class UrlRepositoryImpl implements UrlRepository {

    private Map<String, UrlInfo> urlInfoMap = new HashMap<String, UrlInfo>();
    private Map<String, String> clientUrlToShortUrlMap = new HashMap<String, String>();
    private static String delimiter = ":";

    @Override
    public String saveUrl(UrlInfo urlInfo) throws ValidationException {
        if(urlInfoMap.containsKey(urlInfo.getShortUrl())){
            throw new ValidationException("key already exists");
        }
        String key = urlInfo.getActualUrl() + delimiter + urlInfo.getUserId();
        synchronized (key) {
            if (clientUrlToShortUrlMap.containsKey(key))
                return clientUrlToShortUrlMap.get(key);
            clientUrlToShortUrlMap.put(key, urlInfo.getShortUrl());
            urlInfoMap.put(urlInfo.getShortUrl(), urlInfo);
            return urlInfo.getShortUrl();
        }
    }

    @Override
    public String getUrl(String url) {
        if(url == null || url.isEmpty() || urlInfoMap == null)
            return null;
        UrlInfo urlInfo = urlInfoMap.get(url);

        if(urlInfo == null)
            return null;
        return urlInfo.getActualUrl();
    }
}
