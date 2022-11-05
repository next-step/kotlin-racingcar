package step3.domain.car

class Car {

    private var position: Int = 0

    fun isCurrentPosition(): Int {
        return position
    }

    fun move() {
        position++
    }
}
