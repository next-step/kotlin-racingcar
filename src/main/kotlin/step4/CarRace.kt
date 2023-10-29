package step4

import java.lang.Integer.max

class CarRace(
    carsName: List<String>,
) {
    private val carsStatus = carsName.map {
        if (it.length > 5) throw IllegalArgumentException("cars name length must be less than 5")
        Car(it)
    }
    private var maxPosition = 1

    fun getCarsPosition() = carsStatus.map { it.getCarStatus() }.toList()

    fun doRound() {
        carsStatus.forEach { maxPosition = max(it.doForwardOrNot(), maxPosition) }
    }

    fun getWinners() = carsStatus.filter { car ->
        car.getPosition() == maxPosition
    }
        .map { it.name }
        .toList()
}
