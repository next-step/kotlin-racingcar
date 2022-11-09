package racing.model

@JvmInline
value class CarCount(
    val value: Int
) {
    init {
        require(value > 0) { "잘못된 입력입니다. 0보다 이상의 자동차 숫자를 입력하여야 합니다." }
    }
}
