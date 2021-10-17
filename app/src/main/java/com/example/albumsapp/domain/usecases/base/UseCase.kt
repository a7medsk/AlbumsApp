package com.example.albumsapp.domain.usecases.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 *Created by haskhiri on 17/10/2021
 */
abstract class UseCase {

    protected var lastDisposable: Disposable? = null
    protected val compositeDisposable = CompositeDisposable()

    fun disposeLast() {
        lastDisposable?.let {
            if (!it.isDisposed) {
                it.dispose()
            }
        }
    }

    fun dispose() {
        compositeDisposable.clear()
    }
}