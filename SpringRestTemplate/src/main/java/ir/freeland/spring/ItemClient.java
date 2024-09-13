package ir.freeland.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import ir.freeland.spring.dto.Example;
import ir.freeland.spring.dto.Item;

public class ItemClient {
    private static RestTemplate restTemplate;

    public static void main(String[] args) {

        restTemplate = new RestTemplate(
                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new LoggingRequestInterceptor());
        restTemplate.setInterceptors(interceptors);

        ItemClient itemClient = new ItemClient();

        // System.out.println("Calling GET for entity using arrays");
        // itemClient.getForEntityEmployeesAsArray();
        // System.out.println("Calling GET using ParameterizedTypeReference");
        // itemClient.getAllItemsUsingParameterizedTypeReference();
        // itemClient.createItemUsingLists();
        // itemClient.updateItem();
        itemClient.deleteItem();
    }

    public List<Item> getAllItemsUsingParameterizedTypeReference() {
        ResponseEntity<List<Item>> response =
                restTemplate.exchange("http://localhost:8080/api/items", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Item>>() {});

        List<Item> example = response.getBody();

        assert example != null;
        example.forEach(System.out::println);

        return example;
    }

    public Item[] getForEntityEmployeesAsArray() {
        ResponseEntity<Item[]> response =
                restTemplate.getForEntity("http://127.0.0.1:8080/api/items", Item[].class);

        Item[] employees = response.getBody();

        assert employees != null;
        Arrays.asList(employees).forEach(System.out::println);

        return employees;

    }

    public Item createItemUsingLists() {
        Item newEmployees = new Item("g111", "CARS", 100);

        ResponseEntity<Item> responseEntity = restTemplate
                .postForEntity("http://localhost:8080/api/item/create", newEmployees, Item.class);
        Item item = responseEntity.getBody();

        assert item != null;
        Arrays.asList(item).forEach(System.out::println);

        return item;
    }

    public void createCItemUsingLists() {
        // Example newEmployees = new Example("soo baad");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                "http://localhost:8080/api/item/5/corrupt?reason=very bad", null, String.class);
        // Example item = responseEntity.getBody();

        // assert item != null;
        // Arrays.asList(item).forEach(System.out::println);

        // return item;
    }

    public Item updateItem() {
        Item newEmployees = new Item("g121", "CARS", 10000);

        HttpEntity<Item> requestEntity = new HttpEntity<>(newEmployees);

        ResponseEntity<Item> responseEntity =
                restTemplate.exchange("http://localhost:8080/api/item/7/update", HttpMethod.PUT,
                        requestEntity, Item.class);

        Item item = responseEntity.getBody();
        assert item != null;
        Arrays.asList(item).forEach(System.out::println);
        return item;
    }

    public void deleteItem() {
        restTemplate.delete("http://localhost:8080/api/item/7/delete");
    }
}
