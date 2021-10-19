package racingcar

class Car(val carId: Int, private val minFuelThreshold: Int = 4) {
    var currentPosition: Int = 0

    fun accelerate(fuel: Int) {
        if (fuel > minFuelThreshold) {
            currentPosition += 1
        }
    }
}
