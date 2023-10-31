package racingcar.service

import racingcar.domain.Cars
import racingcar.dto.CarsDto
import racingcar.dto.RacingCarResult

class RacingCarService(private val carName: List<String>, private val operateCount: Int) {

    fun startRacing(): RacingCarResult {
        val cars = Cars(carName)
        val (carsDto, winners) = racingOperation(cars)
        return RacingCarResult(carsDto, winners)
    }

    private fun racingOperation(cars: Cars): Pair<List<CarsDto>, List<String>> {
        val carsDto = mutableListOf<CarsDto>()
        repeat(operateCount) {
            carsDto.add(CarsDto(cars.operateCars().carList))
        }
        return Pair(carsDto, findWinner(carsDto.last()))
    }

    private fun findWinner(carsDto: CarsDto): List<String> {
        val cars = carsDto.cars
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}
