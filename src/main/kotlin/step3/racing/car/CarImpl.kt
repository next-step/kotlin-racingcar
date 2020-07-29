package step3.racing.car

class CarImpl : Car {
    override var distance = 0

    override fun move() {
        distance++
    }
}
