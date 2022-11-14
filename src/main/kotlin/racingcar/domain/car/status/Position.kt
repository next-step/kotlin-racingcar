package racingcar.domain.car.status

data class Position(private var position: Int) {
    init {
        require(position >= 0) { "자동차의 위치는 0 이상이어야 합니다." }
    }

    fun move() {
        position++
    }

    fun getPosition(): Int {
        return position
    }
}
