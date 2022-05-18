package racingcar.domain.car

import racingcar.domain.GasStation

class Cars(
    val values: List<Car>
) {
    fun race(gasStation: GasStation) = values.forEach { car ->
        car.fillGasAndForward(gasStation.getRandomGas())
    }

    fun getWinnerNames(): List<String> {
        val winnerDistance = values.maxOf { it.distance }
        return values.asSequence()
            .filter { it.distance == winnerDistance }
            .map { it.getName() }
            .toList()
    }
}
