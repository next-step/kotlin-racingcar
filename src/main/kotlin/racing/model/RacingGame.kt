package racing.model

object RacingGame {

    fun play(cars: Cars, tryCount: Int): RacingGameResult {
        var movedCar = cars

        val result = List(tryCount) {
            movedCar.moveForward(CarMovingStrategy).also { movedCar = it }
        }

        return RacingGameResult(result)
    }
}
