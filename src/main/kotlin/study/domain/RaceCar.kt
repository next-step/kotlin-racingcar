package study.domain

data class RaceCar(private var position: Int = 0) {
    fun move() {
        position++
    }

    fun getPosition() = position
}
