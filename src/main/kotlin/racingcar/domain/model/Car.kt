package racingcar.domain.model

class Car(val carName: CarName, position: Position) {

    var position: Position = position
        private set

    fun moveTo(count: Int) {
        if (count >= 4) position++
    }

    fun copy(): Car {
        return Car(carName, position)
    }
}

