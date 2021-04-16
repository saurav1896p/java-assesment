package com.example.assesment.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/billers")
public class testController {
    @RequestMapping("/{like}")
    public List<Object> home(@PathVariable String like) {
        final String url = "http://103.210.73.96:8080/bbps/bbps/getBillers?agentID=AGT05082020064F67";

        RestTemplate restTemplate = new RestTemplate();
        HashMap<String, Object> result = restTemplate.postForObject(url, "", HashMap.class);
        ArrayList resultList = (ArrayList) result.get("resultObj");
        String value = (String) resultList.get(0);

        JSONObject jb = new JSONObject(value);
        HashMap<String, Object> map = (HashMap<String, Object>) jb.toMap();

        List<Object> output = new ArrayList<>();

        for (HashMap<String, String> m : (List<HashMap<String, String>>) map.get("Biller")) {
            if (m.get("BlrName").startsWith(like)) {
                output.add(m);
            }
        }
        System.out.println(output);
        return output;
    }
}
