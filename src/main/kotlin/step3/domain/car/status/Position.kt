package step3.domain.car.status

data class Position(var position: Int) {
    fun move() {
        position++
    }
}
