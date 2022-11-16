package racingcar.application.model

data class RaceInputCommand(
    val carCount: Int,
    val attemptCount: Int
) {
    init {
        require(carCount > 0) { "자동차의 개수는 0보다 커야 합니다" }
        require(attemptCount > 0) { "시도 횟수는 0보다 커야 합니다" }
    }
}
