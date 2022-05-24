package com.nextstep.jngcii.racingcar.domain

class Game(
    private val cars: Cars,
    private val trialCount: Int
) {
    fun start(printAction: (car: Car) -> Unit) {
        repeat(trialCount) {
            cars.forEach { it.go() }
            cars.forEach { printAction(it) }
            println()
        }
    }
}
