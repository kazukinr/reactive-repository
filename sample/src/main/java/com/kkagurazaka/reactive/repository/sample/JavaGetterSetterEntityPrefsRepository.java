package com.kkagurazaka.reactive.repository.sample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kkagurazaka.reactive.repository.annotation.PrefsRepository;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

@PrefsRepository(JavaGetterSetterEntity.class)
public interface JavaGetterSetterEntityPrefsRepository {

    @NonNull
    JavaGetterSetterEntity get();

    @NonNull
    Observable<JavaGetterSetterEntity> observe();

    @NonNull
    Flowable<JavaGetterSetterEntity> observeWithBackpressure();

    void store(@Nullable JavaGetterSetterEntity entity);
}
