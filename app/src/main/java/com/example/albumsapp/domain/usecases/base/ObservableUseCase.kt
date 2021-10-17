package com.example.albumsapp.domain.usecases.base

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 *Created by haskhiri on 17/10/2021
 */
abstract class ObservableUseCase<T> : UseCase() {

    internal abstract fun buildUseCaseObservable(): Observable<T>

    fun execute(
        onSuccess: ((t: T) -> Unit),
        onError: ((t: Throwable) -> Unit),
        onFinished: () -> Unit = {}
    ) {
        disposeLast()
        lastDisposable = buildUseCaseObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterTerminate(onFinished)
            .subscribe(onSuccess, onError)

        lastDisposable?.let {
            compositeDisposable.add(it)
        }
    }
}