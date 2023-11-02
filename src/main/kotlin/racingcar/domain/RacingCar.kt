package racingcar.domain

private const val START_POSITION = 0
private const val MOVE_FORWARD_START_NUM = 4
private const val MOVE_FORWARD_COUNT = 1

data class RacingCar(
    val name: String,
    val position: Int = START_POSITION
) {

    fun moveOrStop(checkNum: Int): RacingCar {
        if (checkNum >= MOVE_FORWARD_START_NUM) {
            return RacingCar(name = this.name, position = this.position + MOVE_FORWARD_COUNT)
        }
        return RacingCar(name = this.name, position = position)
    }
}
