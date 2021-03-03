package racingcar.domain

class Car {

    val history = mutableListOf<CarAction>()

    fun move() {
        history.add(CarAction.MOVE)
    }

    fun stop() {
        history.add(CarAction.STOP)
    }
}
