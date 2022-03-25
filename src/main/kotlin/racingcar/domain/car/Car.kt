package racingcar.domain.car

import racingcar.domain.racing.RacingCarAccelerator

data class Car(
    val name: String,
    val accelerator: CarAccelerator = RacingCarAccelerator()
) {

    init {
        require(name.length <= MAX_NAME_LENGTH)
    }

    private val position: CarPosition = CarPosition()

    fun drive() {
        position.applyAction(carAction = accelerator.trigger())
    }

    fun movedDistance(): Int = position.get()

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
