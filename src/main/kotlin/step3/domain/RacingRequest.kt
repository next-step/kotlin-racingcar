package step3.domain

data class RacingRequest(
    val carCount: Int,
    val attemptCount: Int
) {
    init {
        require(carCount > 0) { "carCount must be greater than zero" }
        require(attemptCount > 0) { "attemptCount must be greater than zero" }
    }
}
