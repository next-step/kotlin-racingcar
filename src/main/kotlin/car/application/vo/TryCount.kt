package car.application.vo

@JvmInline
value class TryCount(val value: Int) {
    init {
        require(value > 0) { "시도할 횟수는 0보다 커야합니다." }
    }
}
