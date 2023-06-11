package step3.domain

data class RacingRequest(
    val carNames: List<String>,
    val attemptCount: Int
) {
    init {
        require(carNames.isNotEmpty()) { "carName must be empty" }
        require(carNames.all { it.length <= 5 }) { "carName length must be less then or equal to 5" }
        require(attemptCount > 0) { "attemptCount must be greater than zero" }
    }
}
