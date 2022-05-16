package racingcar

class Car(val distanceMoved: Int = 0) {

    fun move(fuel: Int): Car {
        if (fuel >= 4) {
            return Car(this.distanceMoved.inc())
        }
        return this
    }
}
