package com.kkagurazaka.reactive.repository.sample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kkagurazaka.reactive.repository.annotation.PrefsRepository;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

@PrefsRepository(JavaFieldEntity.class)
public interface JavaFieldEntityPrefsRepository {

    @NonNull
    JavaFieldEntity get();

    @NonNull
    Observable<JavaFieldEntity> observe();

    @NonNull
    Flowable<JavaFieldEntity> observeWithBackpressure();

    void store(@Nullable JavaFieldEntity entity);
}
