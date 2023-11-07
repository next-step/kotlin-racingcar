package racingcar.application

import racingcar.domain.Cars

interface RacingGameUseCase {

    fun createCars(carNameList: List<String>): Cars

    fun run(cars: Cars)

    fun getWinners(cars: Cars): List<String>
}
