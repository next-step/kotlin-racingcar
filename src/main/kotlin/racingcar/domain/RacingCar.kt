package racingcar.domain

import racingcar.domain.carracer.CarRacer
import kotlin.random.Random

private const val MOVING_BENCHMARK = 4

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
        if (canMove()) {
            _movement = Movement(movement + 1)
        }
    }

    private fun canMove() = carRacer.drive() >= MOVING_BENCHMARK
}
