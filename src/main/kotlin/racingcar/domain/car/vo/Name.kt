package racingcar.domain.car.vo

private const val MAXIMUM_NAME_LENGTH = 5

class Name(val value: String) {
    init {
        require(value.isNotEmpty()) { "자동차의 이름은 빈 값일 수 없습니다." }
        require(value.length <= MAXIMUM_NAME_LENGTH) { "자동차의 이름은 ${MAXIMUM_NAME_LENGTH}자 이하여야 합니다." }
    }
}
