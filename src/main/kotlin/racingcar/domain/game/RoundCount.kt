package racingcar.domain.game

@JvmInline
value class RoundCount(
    val value: Int
) {
    init {
        require(value > 0) { "경기 횟수는 0보다 커야 합니다" }
    }
}
