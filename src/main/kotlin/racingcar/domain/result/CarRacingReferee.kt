package racingcar.domain.result

object CarRacingReferee {
    fun getWinners(result: List<CarRacingResult>) =
        result.last().getFarthestCar()
}
