package services.impl;

import core.UrlInfo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UrlRepositoryImpl implements UrlRepository {

    private Map<String, UrlInfo> urlInfoMap = new ConcurrentHashMap<>();
    private Map<String, String> clientUrlToShortUrlMap = new ConcurrentHashMap<>();
    private static String delimiter = ":";

    @Override
    public String saveUrl(UrlInfo urlInfo) throws Exception {
        UrlInfo previousShortUrlMapping = urlInfoMap.putIfAbsent(urlInfo.getShortUrl(), urlInfo);
        if(previousShortUrlMapping != null){
            throw new Exception("Unable to generate unique short URL. Retry");
        }
        String key = urlInfo.getActualUrl() + delimiter + urlInfo.getUserId();
        String previousKey = clientUrlToShortUrlMap.putIfAbsent(key, urlInfo.getShortUrl());
        if(previousKey != null){
            /*
               This is an optimisation to avoid continuous size increase of urlInfoMap.
               If ActualUrl - Client pair already exist in Map-clientUrlToShortUrlMap, we will
               be sticking to older short URL. Hence the insertion for urlInfoMap becomes redundant.
             */
            urlInfoMap.remove(urlInfo.getShortUrl());
            return previousKey;
        }
        return urlInfo.getActualUrl();
    }

    @Override
    public String getUrl(String shortUrl) {
        if(shortUrl == null || shortUrl.isEmpty() || urlInfoMap == null)
            return null;
        UrlInfo urlInfo = urlInfoMap.get(shortUrl);

        if(urlInfo == null)
            return null;
        return urlInfo.getActualUrl();
    }
}
