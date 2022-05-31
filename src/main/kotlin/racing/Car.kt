package racing

class Car(val number: Int, _currentLocation: Int = 0) {
    var currentLocation = _currentLocation
        private set

    fun move() {
        this.currentLocation++
    }
}
