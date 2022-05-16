package racing.model

object RacingGame {

    fun play(cars: Cars, tryCount: Int): RacingGameResult {
        val result = List(tryCount) {
            cars.moveForward(CarMovingStrategy)
            cars
        }

        return RacingGameResult(result)
    }
}
