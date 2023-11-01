package racingcar.domain.result

import racingcar.domain.car.CapturedCar

object CarRacingReferee {
    fun getWinners(result: List<CarRacingResult>): List<CapturedCar> =
        result.last().getFarthestCar()
}
