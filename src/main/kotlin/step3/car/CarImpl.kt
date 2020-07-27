package step3.car

class CarImpl : Car {
    override var distance = 0

    override fun move() {
        distance++
    }
}
