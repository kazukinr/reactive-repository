package com.kkagurazaka.reactive.repository.sample

import com.kkagurazaka.reactive.repository.annotation.PrefsRepository
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable

@PrefsRepository(KotlinDataClassEntity::class)
interface KotlinDataClassEntityPrefsRepository {

    fun get(): KotlinDataClassEntity

    fun observe(): Observable<KotlinDataClassEntity>

    fun observeWithBackpressure(): Flowable<KotlinDataClassEntity>

    fun store(entity: KotlinDataClassEntity?)
}
