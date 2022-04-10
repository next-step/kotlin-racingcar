package racingcar.domain.car

import racingcar.domain.racing.RacingCarAccelerator

data class Car(
    val name: String,
    val accelerator: CarAccelerator = RacingCarAccelerator()
) {

    private val position: CarPosition = CarPosition()

    init {
        require(name.length <= MAX_NAME_LENGTH)
    }

    fun drive() {
        position.applyAction(carAction = accelerator.trigger())
    }

    fun movedDistance(): Int = position.get()

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
