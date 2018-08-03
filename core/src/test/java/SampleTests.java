import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandProperties;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

public class SampleTests {

   /* private static final String URL = "http://11.4.74.47:888/v1/tbempdata/get?id=06645";
    private static final int DEFAULT_SLEEP_MILLIS = 20;
    private static final int DEFAULT_TIMEOUT = 10000;

    @Test(timeout = DEFAULT_TIMEOUT)
    public void syncRestNetty() throws Exception {
        RestTemplate restTemplate = new RestTemplate(new Netty4ClientHttpRequestFactory());
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);

        System.out.println("response = " + response);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void asyncRestNetty() throws Exception {
        AsyncRestTemplate restTemplate = new AsyncRestTemplate(new Netty4ClientHttpRequestFactory());
        //Netty4ClientHttpRequestFactory
        ListenableFuture<ResponseEntity<String>> listenableFuture = restTemplate.getForEntity(URL, String.class);
        listenableFuture.addCallback(result -> System.out.println("result = " + result), Throwable::printStackTrace);
        while (!listenableFuture.isDone()) {
            Thread.sleep(DEFAULT_SLEEP_MILLIS);
        }
        System.out.println("the end");
    }

    @Test
    public void asyncRestOkHttp() throws Exception {
        AsyncRestTemplate restTemplate = new AsyncRestTemplate(new OkHttp3ClientHttpRequestFactory());
        ListenableFuture<ResponseEntity<String>> listenableFuture = restTemplate.getForEntity(URL, String.class);
        listenableFuture.addCallback(result -> System.out.println("result = " + result), Throwable::printStackTrace);
        while (!listenableFuture.isDone()) {
            Thread.sleep(DEFAULT_SLEEP_MILLIS);
        }
        System.out.println("the end");
    }*/


}