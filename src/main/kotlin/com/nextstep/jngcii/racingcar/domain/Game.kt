package com.nextstep.jngcii.racingcar.domain

class Game(
    private val cars: Cars,
    private val trialCount: Int,
    private val history: History
) {
    fun start() {
        repeat(trialCount) {
            cars.forEach { it.goOrStayByDiceCondition() }
            history.write()
        }
    }
}
