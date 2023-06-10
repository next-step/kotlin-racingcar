package step3

data class RacingRequirement(
    val numberOfCars: Int,
    val numberOfTrials: Int,
) {
    init {
        require(numberOfCars > 0) { "자동차 대수는 양수여야 합니다." }
        require(numberOfTrials > 0) { "시도할 횟수는 양수여야 합니다." }
    }
}
