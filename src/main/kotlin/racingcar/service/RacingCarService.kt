package racingcar.service

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.dto.RacingCarResult

class RacingCarService(private val carName: List<String>, private val operateCount: Int) {

    fun startRacing(): RacingCarResult {
        val cars = Cars(carName.map { Car(it) })
        val (carsDto, winners) = racingOperation(cars)
        return RacingCarResult(carsDto, winners)
    }

    private fun racingOperation(cars: Cars): Pair<List<Cars>, List<String>> {
        val carsList = mutableListOf<Cars>()
        repeat(operateCount) {
            carsList.add(Cars(cars.operateCars()))
        }
        return Pair(carsList, findWinner(carsList.last()))
    }

    private fun findWinner(cars: Cars): List<String> {
        val carList = cars.cars
        val maxPosition = carList.maxOf { it.position }
        return carList.filter { it.position == maxPosition }.map { it.name }
    }
}
