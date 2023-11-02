package racinggame.domain

data class RacingGameResult(
    val winners: List<Car>,
    val racingResult: List<RoundResult>
)

data class RoundResult(
    val result: List<Car>
)

