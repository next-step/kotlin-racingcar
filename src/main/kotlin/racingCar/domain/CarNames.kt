package racingCar.domain

class CarNames(
    val names: List<CarName>
) {
    init {
        require(names.size == names.toSet().size) {
            "자동차 이름은 중복될 수 없습니다."
        }
    }
}
