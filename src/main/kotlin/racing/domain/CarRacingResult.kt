package racing.domain

data class CarRacingResult(
    val cars: List<Car>,
    val results: List<List<Car>>,
    val winners: List<String>
)
