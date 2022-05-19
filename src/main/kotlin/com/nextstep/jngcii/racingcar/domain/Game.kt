package com.nextstep.jngcii.racingcar.domain

class Game(
    private val cars: List<Car>,
    private val trialCount: Int,
    private val dice: Dice
) {
    fun start(printAction: (distance: Int) -> Unit) {
        repeat(trialCount) {
            cars.forEach { it.go(dice) }
            cars.forEach { printAction(it.distance) }
        }
    }
}
