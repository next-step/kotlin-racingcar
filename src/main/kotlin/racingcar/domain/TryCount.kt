package racingcar.domain

private const val TRY_MIN_COUNT = 1

@JvmInline
value class TryCount(
    val value: Int
) {
    init {
        require(value >= TRY_MIN_COUNT) {
            "시도 횟수는 $TRY_MIN_COUNT 이상이어야 합니다."
        }
    }
}
