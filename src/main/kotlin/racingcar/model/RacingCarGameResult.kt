package racingcar.model

data class RacingCarGameResult(
    val gameCount: GameCount,
    val snapshots: List<RacingCarGameSnapshot>,
    val winnerCars: List<Car>
)
