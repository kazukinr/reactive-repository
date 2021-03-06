package com.kkagurazaka.reactive.repository.sample;

import com.kkagurazaka.reactive.repository.annotation.InMemoryEntity;
import com.kkagurazaka.reactive.repository.annotation.PrefsEntity;
import com.kkagurazaka.reactive.repository.annotation.PrefsKey;

import java.util.*;

@InMemoryEntity
@PrefsEntity(typeAdapter = SomeClassListTypeAdapter.class)
public class JavaFieldEntity {

    @PrefsKey
    public boolean isVeteran = false;

    @PrefsKey
    public String someStr = null;

    @PrefsKey
    public int age = -1;

    @PrefsKey
    public float pie = 3.1415f;

    @PrefsKey
    public long amount = 123456789L;

    @PrefsKey
    public Set<String> strList = new HashSet<>();

    @PrefsKey
    public List<SomeClass> someClassList = new ArrayList<>(Collections.singletonList(new SomeClass("initial")));
}
