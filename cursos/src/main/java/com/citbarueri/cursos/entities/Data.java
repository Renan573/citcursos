package com.citbarueri.cursos.entities;

import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.citbarueri.cursos.model.Cursos;

/*
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
*/
        /*
        HttpClient client = HttpClient.newHttpClient();
        String token = "13cbe49b9403e5a4fadfa7da0c81987308e86459b3a63e237b193debe9180d9e";
        String api_url = "https://api.sympla.com.br/public/v3/events";
        HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(api_url))
                        .GET()
                        .setHeader("s_token", token)
                        .build();
                        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int status = response.statusCode();

        if (status >= 200 && status < 300) {
            String json = response.body();
            System.out.println(json);
        }
        else {
            String json = response.body();
            System.out.println(status + " " + json);
        }
        */

public class Data {
    private static String token = "13cbe49b9403e5a4fadfa7da0c81987308e86459b3a63e237b193debe9180d9e";
    // String old_token = "be9283d68b3ad7216a3ea59742d19df4b82616e03f3a535aa806a10bd56ab1ec";
    private static String api_url = "https://api.sympla.com.br/public/v3/events";

    private static Data data;
    
    private JSONObject jsonObject;

    private Data() {
        this.jsonObject = new JSONObject();
    }

    public static Data getData() {
        if (data == null) {
            data = new Data();
        }

        return data;

    }

    private JSONObject getJSONData() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(api_url))
                        .GET()
                        .setHeader("s_token", token)
                        .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int status = response.statusCode();

            if (status >= 200 && status < 300) {
                String json = response.body();
                this.jsonObject = new JSONObject(json);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this.jsonObject;
    }

    public List<Cursos> getCoursesList() {

        List<Cursos> courses = new ArrayList<Cursos>();

        Data jsonfile = Data.getData();
        JSONObject jsonObject = jsonfile.getJSONData();
        JSONArray value = jsonObject.getJSONArray("data");
        JSONObject value_aux;
        Cursos curso;
        JSONObject address_value;
        Address address;
        JSONObject host_value;
        Host host;
        JSONObject category_prim_value;
        CategoryPrim categoryPrim;
        JSONObject category_sec_value;
        CategorySec categorySec;
        for (int i = 0; i < value.length(); i++) {
            value_aux = value.getJSONObject(i);
            address_value = value_aux.getJSONObject("address");
            host_value = value_aux.getJSONObject("host");
            category_prim_value = value_aux.getJSONObject("category_prim");
            category_sec_value = value_aux.getJSONObject("category_sec");

            address = new Address(address_value.getString("name"),
            isStringNull("address", address_value),
            isStringNull("address_num", address_value),
            isStringNull("address_alt", address_value),
            isStringNull("neighborhood", address_value),
            address_value.getString("city"),
            isStringNull("state", address_value),
            isStringNull("zip_code", address_value),
            isStringNull("country", address_value));

            host = new Host(host_value.getString("name"),
            host_value.getString("description"));

            categoryPrim = new CategoryPrim(category_prim_value.getString("name"));

            categorySec = new CategorySec(isStringNull("name", category_sec_value));
            
            curso = new Cursos(value_aux.getInt("id"),
            value_aux.getString("start_date"), value_aux.getString("end_date"),
            value_aux.getString("name"), value_aux.getString("detail"),
            value_aux.getInt("private_event"), value_aux.getInt("published"),
            value_aux.getInt("cancelled"), value_aux.getString("image"),
            value_aux.getString("url"), address, host, categoryPrim, categorySec);

            courses.add(curso);
            
        }

        return courses;
    }

    public static String isStringNull(String name, JSONObject jsonObject) {
        Object nullString = jsonObject.get(name);
        if (nullString == JSONObject.NULL) {
            return null;
        }
        else {
            return nullString.toString();
        }
    }

}