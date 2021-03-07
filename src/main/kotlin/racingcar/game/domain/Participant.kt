package racingcar.game.domain

import racingcar.game.vo.GameRoundResult

class Participant(nameOfCar: List<String>) {
    val cars = nameOfCar.map { Car(name = it) }

    fun moveCars(condition: () -> Int): GameRoundResult {
        cars.forEach { it.move(condition()) }
        return GameRoundResult(cars.map { Car(it.name, it.position) })
    }
}
