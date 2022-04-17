package racingcar.domain.car

import racingcar.domain.racing.RacingCarAccelerator

class Car(
    val name: String,
    val accelerator: CarAccelerator = RacingCarAccelerator(),
    private val position: CarPosition = CarPosition()
) {

    val movedDistance: Int
        get() = position.get()

    init {
        require(name.length <= MAX_NAME_LENGTH)
    }

    fun drive(): Car = Car(
        name = name,
        accelerator = accelerator,
        position = position.applyAction(accelerator.trigger())
    )

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
