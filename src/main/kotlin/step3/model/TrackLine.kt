package step3.model

class TrackLine(val car: Car) {

    var position: Int = 0
        private set

    fun move() {
        if (car.move()) {
            position++
        }
    }
}
