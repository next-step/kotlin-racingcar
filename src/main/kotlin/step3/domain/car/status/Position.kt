package step3.domain.car.status

data class Position(var position: Int) {
    init {
        require(position >= 0) { "자동차의 위치는 0 이상이어야 합니다." }
    }

    fun move() {
        position++
    }
}
