package step4.domain

data class RacingGame(
    val tryCount: Int,
    val racingCars: RacingCars
) {
    fun run(
        afterTrying: (RacingCar) -> Unit,
        afterOneRepeat: () -> Unit,
    ) {
        repeat(tryCount) {
            moveCarsInOneTry(afterTrying)
            afterOneRepeat()
        }
    }

    private fun moveCarsInOneTry(afterTrying: (RacingCar) -> Unit) {
        for (car in racingCars.racingCars) {
            car.tryMoving()
            afterTrying(car)
        }
    }

    fun getWinnerList(): List<RacingCar> = racingCars.winner
}
