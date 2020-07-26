package step3.car

class CarImpl(override val id: Int) : Car {
    override var distance = 0

    override fun move() {
        distance++
    }

    override fun equals(other: Any?): Boolean {
        return other is CarImpl && other.id == id
    }
}
