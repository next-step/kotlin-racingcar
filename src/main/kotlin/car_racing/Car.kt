package car_racing

class Car {
    var position: Int = 0
        private set

    fun move() {
        this.position += 1
    }
}
