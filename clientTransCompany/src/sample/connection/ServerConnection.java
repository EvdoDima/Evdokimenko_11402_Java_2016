package sample.connection;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import sample.models.ApplicationsEntity;
import sample.models.CarsEntity;
import sample.models.OrdersEntity;
import sample.models.UsersEntity;
import sample.models.enums.UserRole;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by evdodima on 24/05/16.
 * 11-402
 */
public class ServerConnection {
    private final String SERVER_URL = "http://localhost:8080/rest/api/";

    public UserRole getUserRole() throws Exception {
        return mapper().readValue(getResponse("role"), UserRole.class);
    }

    public List<OrdersEntity> getOrders() {
        try {
            return Arrays.asList(mapper().readValue(getResponse("orders"), OrdersEntity[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public List<ContractEntity> getContracts() {
//        try {
//            return Arrays.asList(mapper().readValue(getResponse("contracts"), ContractEntity[].class));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    private ObjectMapper mapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        return mapper;
    }

    private String getResponse(String path) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new CustomResponseErrorHandler());
        String url = SERVER_URL + path;
        ResponseEntity resp = restTemplate.exchange(url, HttpMethod.GET, request(path), String.class);
        return resp.getBody().toString();
    }

    private void doPost(String path, Object object) {
        String url = SERVER_URL + path;
        try {
            new RestTemplate().exchange(url, HttpMethod.POST, request(object), object.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HttpEntity<String> request() throws IOException {
        return request(null);
    }

    private HttpEntity request(Object payload) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", ServerAuth.getLoginPass());
        return new HttpEntity(payload, headers);
    }

    public List<ApplicationsEntity> getApplications() {
        try {
            return Arrays.asList(mapper().readValue(getResponse("applications"), ApplicationsEntity[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateOrderStatus(long id) {
        doPost("/orders", id);
    }

    public List<CarsEntity> getAvailableCars() {
        try {
            return Arrays.asList(mapper().readValue(getResponse("cars/available"), CarsEntity[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateApplication(long id) {
        doPost("/applications", id);

    }

    public List<CarsEntity> getCars() {
        try {
            return Arrays.asList(mapper().readValue(getResponse("cars"), CarsEntity[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }    }

    public void postNewApplication(ApplicationsEntity applicationsEntity) {
        doPost("/applications/new",applicationsEntity);
    }

    public void postNewCar(CarsEntity carsEntity) {
        doPost("/cars/new",carsEntity);
    }

    public void postNewUser(UsersEntity usersEntity) {
        doPost("users/new",usersEntity);
    }
}
