package racingCar.domain

import racingCar.dto.ResultDto

class Racing(usernames: List<String>, strategy: MoveStrategy) {

    private val cars = Cars(usernames.map { Username(it) }.toList(), strategy)

    fun play(): ResultDto {
        cars.moveByStrategy()
        return ResultDto(cars)
    }

    fun pickWinner(): List<Username> {
        val winners = cars.findWinners();
        checkNotNull(winners)
        return winners
    }
}
