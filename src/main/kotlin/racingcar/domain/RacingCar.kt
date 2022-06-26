package racingcar.domain

import racingcar.domain.carracer.CarRacer

class RacingCar(
    name: Name,
    movement: Movement,
    private val carRacer: CarRacer,
) {
    private var _name: Name = name
    private var _movement: Movement = movement
    val name: String
        get() = _name.value
    val movement: Int
        get() = _movement.value

    constructor(carRacer: CarRacer) : this(
        name = Name(),
        movement = Movement(),
        carRacer,
    )

    constructor(racingCarName: Name, carRacer: CarRacer) : this(
        racingCarName,
        Movement(),
        carRacer,
    )

    fun move() {
        if (carRacer.canMove()) {
            _movement = Movement(movement + 1)
        }
    }
}
