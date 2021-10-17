package racingcar.model

data class RacingCarGameResult(
    val gameCount: GameCount,
    val snapshots: List<RacingCarSnapshot>,
    val winnerCars: List<Car>
)
