package racingcar.domain

class Car(private val movable: Movable) {
    private var location = 0

    fun isMoveOrStop() {
        if (movable.move()) location++
    }

    fun getLocation(): Int {
        return location
    }
}
