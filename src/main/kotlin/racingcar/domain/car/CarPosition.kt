package racingcar.domain.car

data class CarPosition(private val position: Int = 0) {

    fun get() = position

    fun applyAction(carAction: CarAction): CarPosition =
        CarPosition(position + carAction.distance)
}
