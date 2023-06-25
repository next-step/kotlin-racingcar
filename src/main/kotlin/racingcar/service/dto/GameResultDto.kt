package racingcar.service.dto

import racingcar.domain.Car

data class GameResultDto(val stage: Int, val cars: List<Car>)
