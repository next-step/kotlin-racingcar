package racingcar.domain.car

class CarNames(
    val values: List<CarName>
) {
    init {
        validateDuplicate(value = this.values)
    }

    private fun validateDuplicate(value: List<CarName>) {
        if (value.size != value.toSet().size) {
            throw IllegalArgumentException("자동차 이름은 서로 중복될 수 없습니다.")
        }
    }
}
