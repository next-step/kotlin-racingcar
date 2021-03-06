package racingcar.game.domain

import racingcar.game.vo.GameRoundResult

class Participant(nameOfCar: List<String>) {
    val gameResult = mutableListOf<GameRoundResult>()

    private val cars = nameOfCar.map { Car(name = it) }

    fun moveCars(condition: () -> Int) {
        cars.forEach { it.move(condition()) }
    }

    fun setRoundResult() {
        gameResult.add(GameRoundResult(cars.map { Car(it.name, it.position) }))
    }
}
