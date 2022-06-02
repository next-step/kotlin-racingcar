package com.nextstep.jngcii.racingcar.domain

class Game(
    private val cars: Cars,
    private val trialCount: Int,
    private val history: History
) {
    fun start(): Winners {
        repeat(trialCount) {
            cars.forEach { it.go() }
            history.write()
        }
        return Winners(cars)
    }
}
