package com.tmri;

import com.tmri.base.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class ApiTest {

    public static void main(String[] args) {

        while(true){
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Result>  resultResponseEntity =
                    restTemplate.getForEntity("http://localhost:8888/TMRI-PLATE-SERVICE-USER/test/save",Result.class);
            log.info(resultResponseEntity.getBody().toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
