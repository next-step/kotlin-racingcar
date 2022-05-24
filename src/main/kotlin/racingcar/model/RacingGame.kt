package racingcar.model

class RacingGame(
    val tryNumber: TryNumber,
    val cars: Cars
) {
    fun startGame(): RacingGameResult {
        val finishedResults = startGame(cars, tryNumber, listOf())
        return RacingGameResult(
            results = finishedResults,
            winners = finishedResults.last().cars.findWinners()
        )
    }

    private tailrec fun startGame(
        cars: Cars,
        tryNumber: TryNumber,
        racingGameResult: List<RacingDataPerTry>
    ): List<RacingDataPerTry> {
        if (tryNumber.isZero()) {
            return racingGameResult
        }

        val movedCars = race(cars)
        return startGame(movedCars, tryNumber.minus(), racingGameResult + RacingDataPerTry(movedCars))
    }

    private fun race(cars: Cars): Cars {
        return cars.moveForwardCars()
    }
}
