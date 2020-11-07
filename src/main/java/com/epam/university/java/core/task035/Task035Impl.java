package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
//import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class Task035Impl implements Task035 {
    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) throws IOException {
        PersonImpl person = mapper.readValue(jsonString, PersonImpl.class);
        return person;
    }

    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        Gson gson = builder.create();
        PersonImpl person = gson.fromJson(jsonString, PersonImpl.class);

  //      Type listType = new TypeToken<ArrayList<PhoneNumberImpl>>(){}.getType();
 //       List<PhoneNumberImpl> you = builder.create().fromJson(jsonString, listType);
//        Gson gson = builder.create();
 //       Person person = gson.fromJson(jsonString, PersonImpl.class);
        return person;
    }
}
//List<MyClass> myObjects = mapper.readValue(jsonInput,
// mapper.getTypeFactory().constructCollectionType(List.class, MyClass.class));
//пользовательский десириализатр
//registerTypeAdapter