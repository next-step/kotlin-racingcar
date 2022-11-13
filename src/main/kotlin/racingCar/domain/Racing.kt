package racingCar.domain

import racingCar.dto.ResultDto

class Racing(usernames: List<Username>, strategy: MoveStrategy) {

    private val cars = Cars(usernames, strategy)
    fun play(): ResultDto {
        cars.moveByStrategy()
        return ResultDto(cars)
    }
}
