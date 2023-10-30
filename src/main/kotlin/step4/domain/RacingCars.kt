package step4.domain

data class RacingCars(val racingCars: List<RacingCar>) {
    val winner
        get() = run {
            val maxMove = racingCars.maxOf { it.moveCount }
            racingCars.filter { it.moveCount == maxMove }
        }
}
