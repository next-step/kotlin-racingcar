package racingCar.domain

import racingCar.dto.ResultDto

class Racing(carNumber: Int, strategy: MoveStrategy) {

    private val cars = Cars(carNumber, strategy)
    fun play(): ResultDto {
        cars.moveByStrategy()
        return ResultDto(cars)
    }
}
