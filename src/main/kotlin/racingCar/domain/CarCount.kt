package racingCar.domain

private const val CAR_MIN_COUNT = 1

@JvmInline
value class CarCount(
    val value: Int
) {
    init {
        require(value >= CAR_MIN_COUNT) {
            "자동차 개수는 $CAR_MIN_COUNT 이상이어야 합니다."
        }
    }
}
