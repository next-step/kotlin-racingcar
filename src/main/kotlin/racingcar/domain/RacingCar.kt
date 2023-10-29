package racingcar.domain

private const val INIT_COUNT = 0
private const val MOVE_FORWARD_START_NUM = 4
private const val MOVE_FORWARD_COUNT = 1

data class RacingCar(
    val name: String,
    val count: Int = INIT_COUNT
) {

    fun moveOrStop(checkNum: Int): RacingCar {
        if (checkNum >= MOVE_FORWARD_START_NUM) {
            return RacingCar(name = this.name, count = this.count + MOVE_FORWARD_COUNT)
        }
        return RacingCar(name = this.name, count = count)
    }
}
