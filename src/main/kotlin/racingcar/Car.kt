package racingcar

class Car(val distanceMoved: Int = 0) {

    fun move(value: Int) : Car {
        if (value >= 4) {
            return Car(this.distanceMoved.inc())
        }
        return this
    }
}
