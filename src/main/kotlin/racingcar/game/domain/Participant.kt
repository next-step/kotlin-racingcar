package racingcar.game.domain

import racingcar.game.vo.GameRoundResult

class Participant(nameOfCar: List<String>) {
    val cars = nameOfCar.map { Car(name = it) }

    fun getRoundResult(): GameRoundResult {
        return GameRoundResult(cars.map { it.copy(it.name, it.position) }) // for deep copy
    }
}
