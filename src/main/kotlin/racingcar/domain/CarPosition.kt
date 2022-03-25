package racingcar.domain

data class CarPosition(private var position: Int = 0) {

    fun get() = position

    fun applyAction(carAction: CarAction) {
        position += carAction.distance
    }
}
