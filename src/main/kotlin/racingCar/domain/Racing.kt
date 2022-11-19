package racingCar.domain

import racingCar.dto.ResultDto

class Racing(carNames: List<String>, strategy: MoveStrategy) {

    private val cars = Cars(carNames, strategy)

    fun play(): ResultDto {
        cars.moveByStrategy()
        return ResultDto(cars)
    }

    fun pickWinner(): List<Car> = cars.findWinners()
}
