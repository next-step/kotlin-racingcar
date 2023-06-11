package step3

data class RacingRequirement(
    val carNames: List<String>,
    val numberOfTrials: Int,
) {
    init {
        require(carNames.isNotEmpty()) { "자동차 이름은 1개 이상 존재해야 합니다" }
        require(numberOfTrials > 0) { "시도할 횟수는 양수여야 합니다." }
    }
}
