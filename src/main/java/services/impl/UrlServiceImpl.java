package services.impl;

import core.Exception.ValidationException;
import core.UrlInfo;
import helper.DateHelper;
import helper.StringHelper;
import services.ClientService;
import services.ConfigRepository;
import services.UniqueKeyGenerator;
import services.UrlService;

public class UrlServiceImpl implements UrlService {
    private UniqueKeyGenerator uniqueKeyGenerator;
    private ClientService clientService;
    private ConfigRepository configRepository;
    private UrlRepository urlRepository;

    public UrlServiceImpl(UniqueKeyGenerator uniqueKeyGenerator, ClientService clientService, ConfigRepository configRepository, UrlRepository urlRepository) {
        this.uniqueKeyGenerator = uniqueKeyGenerator;
        this.clientService = clientService;
        this.configRepository = configRepository;
        this.urlRepository = urlRepository;
    }

    public String getShortenedUrl(String url, String clientId) throws ValidationException {
        if(url == null || url.isEmpty()){
            throw new ValidationException("url can not be empty");
        }
        if(!clientService.verifyClient(clientId)){
           throw new ValidationException("Client ID not found");
        }
        String uniqueKey = uniqueKeyGenerator.getNewKey();
        uniqueKey = validateAndPadKey(uniqueKey);
        return urlRepository.saveUrl(new UrlInfo(uniqueKey, url, DateHelper.addDays(configRepository.getExpiryDays()), clientId));
    }

    private String validateAndPadKey(String key) throws ValidationException {
        if(key == null || key.isEmpty())
            throw  new ValidationException("Key can not be empty");
        if(configRepository.getKeyLength() == key.length()){
            return key;
        }
        StringBuilder sb = new StringBuilder(key);
        sb.append("-");
        for(int i = 1 ; i < configRepository.getKeyLength() - key.length(); i++){
            sb.append(StringHelper.getRandomChar());
        }
        return sb.toString();
    }


    public String getActualUrl(String url) {
        return urlRepository.getUrl(url);
    }
}
