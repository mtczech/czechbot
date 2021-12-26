package data_classes;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pokemon_deserializers.MoveURLDeserializer;

import java.util.HashMap;


@JsonDeserialize(using = MoveURLDeserializer.class)
public class MoveURLList {
    //Map mapping move names to URLs
    private HashMap<String, String> urls;

    public MoveURLList() {

    }

    public void setUrls(HashMap<String, String> setUrls) {
        urls = setUrls;
    }

    public HashMap<String, String> getUrls() {
        return urls;
    }

    public String returnUrl(String moveKey) {
        return urls.get(moveKey);
    }
}
