package core;

import java.util.Date;

public class UrlInfo {
    private String shortUrl;
    private String actualUrl;
    private Date createdDate;
    private Date expiryDate;
    private String userId;

    public UrlInfo(String shortUrl, String actualUrl, Date expiryDate, String userId) {
        this.shortUrl = shortUrl;
        this.actualUrl = actualUrl;
        this.expiryDate = expiryDate;
        this.userId = userId;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getActualUrl() {
        return actualUrl;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getUserId() {
        return userId;
    }

}
