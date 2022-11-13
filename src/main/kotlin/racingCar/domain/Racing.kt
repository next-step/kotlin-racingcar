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
        checkNotNull(winners){"우승자는 없을 수 없습니다. 동점자인 경우 여러 우승자를 허용합니다. "}
        return winners
    }
}
