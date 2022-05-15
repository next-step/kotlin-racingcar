package step3.model

class TrackLine(val car: Car) {

    var position: Int = 0

    fun move() {
        if (car.move()) {
            position++
        }
    }
}
