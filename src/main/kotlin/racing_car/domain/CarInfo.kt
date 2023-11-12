package racing_car.domain

data class CarInfo(
    val name: String,
    val moveStrategy: MoveStrategy,
) {
    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }
}
