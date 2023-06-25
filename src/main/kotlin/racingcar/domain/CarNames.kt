package racingcar.domain

data class CarNames(val value: List<CarName>) {
    init {
        require(value.isNotEmpty()) { "Car 이름이 없습니다." }
    }
}
