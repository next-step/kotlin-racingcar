package racingcar.domain

import racingcar.domain.carracer.CarRacer
import kotlin.random.Random

private const val DEFAULT_MOVEMENT = 0
private const val MOVING_BENCHMARK = 4
private val chars = (('A'..'Z') + ('0'..'9'))
private fun getDefaultName() = (0..4)
    .map { chars[Random.nextInt(chars.size)] }
    .joinToString("")

class RacingCar(racingCarName: RacingCarName, private val carRacer: CarRacer) {

    private var _racingCarName: RacingCarName = racingCarName

    val name: String
        get() = _racingCarName.value

    var movement = DEFAULT_MOVEMENT
        private set

    constructor(carRacer: CarRacer) : this(racingCarName = RacingCarName(getDefaultName()), carRacer)

    fun move() {
        if (canMove()) {
            movement++
        }
    }

    private fun canMove() = carRacer.drive() >= MOVING_BENCHMARK
}
