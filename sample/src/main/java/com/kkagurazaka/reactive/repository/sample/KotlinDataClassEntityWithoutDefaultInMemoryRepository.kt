package com.kkagurazaka.reactive.repository.sample

import com.kkagurazaka.reactive.repository.annotation.InMemoryRepository
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable

@InMemoryRepository(KotlinDataClassEntityWithoutDefault::class)
interface KotlinDataClassEntityWithoutDefaultInMemoryRepository {

    fun get(): KotlinDataClassEntityWithoutDefault?

    fun observe(): Observable<KotlinDataClassEntityWithoutDefault>

    fun observeWithBackpressure(): Flowable<KotlinDataClassEntityWithoutDefault>

    fun store(entity: KotlinDataClassEntityWithoutDefault)
}
