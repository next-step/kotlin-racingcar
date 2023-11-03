package racingCar.domain

private const val CAR_NAME_MIN_LENGTH = 1
private const val CAR_NAME_MAX_LENGTH = 5

@JvmInline
value class CarName(
    val value: String
) {
    init {
        require(value.length in CAR_NAME_MIN_LENGTH..CAR_NAME_MAX_LENGTH) {
            "자동차 이름은 ${CAR_NAME_MIN_LENGTH}글자 이상, ${CAR_NAME_MAX_LENGTH}글자 이하여야 합니다."
        }
    }
}
