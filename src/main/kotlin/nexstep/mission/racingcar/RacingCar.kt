package nexstep.mission.racingcar

private const val MOVEMENT_CONDITION = 4

class RacingCar(var position: Int = 0) {

    fun move(random: Int) {
        if (random >= MOVEMENT_CONDITION) {
            ++position
        }
    }
}
