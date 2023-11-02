package racingcar.domain

data class RacingPlayers(
    private val nameOfCars: String,
    val numberOfTrials: Int,
    val names: List<String> = nameOfCars.split(",")
)
