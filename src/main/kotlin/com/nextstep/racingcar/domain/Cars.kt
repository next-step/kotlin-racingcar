package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.rules.MoveRule

class Cars(cars: List<Car>) {
    val cars: List<Car> = cars.toList()
    constructor(carNames: Set<String>) : this(carNames.map { Car(it) })

    fun play(moveRule: MoveRule): Unit = cars.forEach { it.move(moveRule) }

    fun findWinners(): List<Car> {
        val winnerLocation = cars.maxOf { it.getLocation() }
        return cars.filter { it.getLocation() == winnerLocation }
    }
}
