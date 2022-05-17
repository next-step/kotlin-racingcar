package step3

data class Car(
    val forward: Boolean = true
)

data class Round(
    val roundNumber: Int,
    val raceResult: List<Car>
)