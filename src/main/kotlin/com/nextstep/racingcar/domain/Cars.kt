package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.rules.MoveRule

class Cars(carNames: List<String>) {
    private val cars: List<Car> = carNames.map { Car(it) }

    fun play(moveRule: MoveRule) = cars.forEach { it.move(moveRule) }

    fun getHistories(): List<Pair<String, List<Movement>>> = cars.map { Pair(it.name, it.getHistories()) }
}
