package first_week_carrace.model

import first_week_carrace.utils.MAX_NAME_LENGTH
import java.lang.Integer.max

class CarRace(
    carNames: List<String>,
) {
    private val carsStatus = carNames.map {
        require(it.length <= MAX_NAME_LENGTH)
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
