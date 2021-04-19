package services;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.impl.*;

public class UrlServiceTest {

    private UrlService urlService;

    @BeforeMethod
    public void setUp() {
        UniqueKeyGenerator uniqueKeyGenerator = new UniqueKeyGeneratorImpl();
        ClientService clientService = new ClientServiceImpl();
        ConfigRepository configRepository = new ConfigRepositoryImpl();
        UrlRepository urlRepository = new UrlRepositoryImpl();
        urlService = new UrlServiceImpl(uniqueKeyGenerator, clientService, configRepository, urlRepository);
    }

    @Test
    public void testUpdateHolidayConfigBucket() throws Exception {
        String a = urlService.getShortenedUrl("www.sagar.com", "sagar");
        System.out.println(urlService.getShortenedUrl("www.sagar.com", "sagar"));
        System.out.println(urlService.getShortenedUrl("www.sagar.com", "sagar"));

        System.out.println(urlService.getShortenedUrl("www.sagar.com/happy", "sagar"));
        System.out.println(urlService.getShortenedUrl("www.sagar.com", "sagar1"));

        System.out.println(urlService.getShortenedUrl("www.sagar.com", "sagar"));
        System.out.println(urlService.getShortenedUrl("www.sagar.com", "sagar"));

        System.out.println(urlService.getActualUrl(urlService.getShortenedUrl("www.sagar.com", "sagar1")));
        System.out.println(urlService.getActualUrl(a));

    }
}
