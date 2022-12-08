package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.rules.MoveRule

class Cars(private val cars: List<Car>) {

    constructor(carNames: Set<String>) : this(carNames.map { Car(it) })

    fun play(moveRule: MoveRule): Unit = cars.forEach { it.move(moveRule) }

    fun getHistories(): List<Pair<String, List<Movement>>> = cars.map { Pair(it.name, it.getHistories()) }

    fun findWinners(): List<Car> {
        val winnerLocation = cars.maxOf { it.getLocation() }
        return cars.filter { it.getLocation() == winnerLocation }
    }
}
