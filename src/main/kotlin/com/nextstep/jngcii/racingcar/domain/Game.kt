package com.nextstep.jngcii.racingcar.domain

class Game(
    private val cars: Cars,
    private val trialCount: Int,
    private val dice: Dice
) {
    fun start(printAction: (car: Car) -> Unit) {
        repeat(trialCount) {
            cars.forEach { it.go(dice) }
            cars.forEach { printAction(it) }
            println()
        }
    }
}
