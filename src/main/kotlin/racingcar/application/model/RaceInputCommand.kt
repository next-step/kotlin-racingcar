package racingcar.application.model

data class RaceInputCommand(
    val carNames: List<String>,
    val attemptCount: Int,
    val carCount: Int
) {
    init {
        require(carNames.isNotEmpty()) { "자동차의 개수는 0보다 커야 합니다" }
        require(attemptCount > 0) { "시도 횟수는 0보다 커야 합니다" }
        check(carCount == carNames.size) { "자동차의 개수와 입력한 이름의 개수는 동일해야 합니다." }
    }
}
