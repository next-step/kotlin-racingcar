package racing.domain

data class CarRacingResult(
    val results: List<List<Car>>,
    val winners: List<String>
)
