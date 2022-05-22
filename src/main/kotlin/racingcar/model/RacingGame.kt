package racingcar.model

class RacingGame(
    val tryNumber: TryNumber,
    val cars: Cars
) {
    fun startGame(): RacingGameResult {
        val racingGameResult = mutableListOf<RacingDataPerTry>()
        val finishedCars = startGame(cars, tryNumber, racingGameResult)
        return RacingGameResult(
            result = racingGameResult,
            winners = finishedCars.findWinners()
        )
    }

    private tailrec fun startGame(
        cars: Cars,
        tryNumber: TryNumber,
        racingGameResult: MutableList<RacingDataPerTry>
    ): Cars {
        if (tryNumber.isZero()) {
            return cars
        }
        val movedCars = race(cars)
        racingGameResult.add(RacingDataPerTry(cars = movedCars))
        return startGame(movedCars, tryNumber.minus(), racingGameResult)
    }

    private fun race(cars: Cars): Cars {
        return cars.moveForwardCars()
    }
}
