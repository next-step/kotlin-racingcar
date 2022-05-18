package racingcar.domain.car

class CarNames(
    val values: List<CarName>
) {
    init {
        validateDuplicate(value = this.values)
    }

    private fun validateDuplicate(value: List<CarName>) {
        require(value.size == value.toSet().size) { "자동차 이름은 서로 중복될 수 없습니다." }
    }
}
