package nexstep.mission.racingcar

import nexstep.mission.racingcar.vo.Name

private const val MOVEMENT_CONDITION = 4

class RacingCar(
    val name: Name,
    position: Int = 0
) {
    constructor(name: String) : this(Name(name))

    var position = position
        private set

    fun move(movement: Int) {
        if (movement >= MOVEMENT_CONDITION) {
            ++position
        }
    }
}
