package com.nextstep.jngcii.racingcar.domain

class Car(val name: String) {
    private var _distance = INITIAL_DISTANCE
    val distance get() = _distance

    fun go() {
        _distance += SINGLE_COUNT
    }

    companion object {
        private const val INITIAL_DISTANCE = 0
        private const val SINGLE_COUNT = 1
    }
}
