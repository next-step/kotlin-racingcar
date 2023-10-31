package first_week_carrace

import java.lang.Integer.max

class CarRace(
    carNames: List<String>,
) {
    private val carsStatus = carNames.map {
        require(it.length <= 5)
        Car(it)
    }
    private var maxPosition = 1

    fun getCarsPosition() = carsStatus.map { Pair(it.name, it.position) }.toList()

    fun doRound() {
        carsStatus.forEach { maxPosition = max(it.doForwardOrNot(), maxPosition) }
    }

    fun getWinners() = carsStatus.filter { car ->
        car.position == maxPosition
    }
        .map { it.name }
        .toList()
}
