package nexstep.mission.racingcar

import nexstep.mission.racingcar.vo.Name

private const val MOVEMENT_CONDITION = 4

class RacingCar(
    val name: Name,
    var position: Int = 0
) {
    constructor(name: String) : this(Name(name))

    fun move(random: Int) {
        if (random >= MOVEMENT_CONDITION) {
            ++position
        }
    }
}
