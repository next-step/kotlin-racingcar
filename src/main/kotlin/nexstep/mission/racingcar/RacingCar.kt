package nexstep.mission.racingcar

import nexstep.mission.racingcar.vo.Name

private const val MOVEMENT_CONDITION = 4

class RacingCar(
    val name: Name,
    var position: Int = 0
) {
    constructor(name: String) : this(Name(name))

    fun move(movement: Int) {
        if (movement >= MOVEMENT_CONDITION) {
            ++position
        }
    }
}
