package racing.domain

data class CarRacingResult(
    val cars: List<Car>,
    val results: List<List<CarRacingRecord>>,
    val winners: List<String>
)
