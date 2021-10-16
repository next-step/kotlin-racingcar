package racingcar.model

data class RacingCarGameResult(
    val carCount: CarCount,
    val gameCount: GameCount,
    val cars: List<Car>
)
