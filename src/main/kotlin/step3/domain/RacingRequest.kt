package step3.domain

data class RacingRequest(
    val cars: List<CarRequest>,
    val attemptCount: Int,
) {
    init {
        require(cars.isNotEmpty()) { "carName must be empty" }
        require(cars.all { it.name.length <= 5 }) { "carName length must be less then or equal to 5" }
        require(attemptCount > 0) { "attemptCount must be greater than zero" }
    }
}
