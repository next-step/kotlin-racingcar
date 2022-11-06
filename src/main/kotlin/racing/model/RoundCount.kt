package racing.model

@JvmInline
value class RoundCount(
    val value: Int
) {
    init {
        require(value > 0) { "잘못된 입력입니다. 0보다 이상의 경주게임 시도 횟수를 입력하여야 합니다." }
    }
}
