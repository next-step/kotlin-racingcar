package racingcar.domain

private const val INIT_COUNT = 0
private const val MOVE_FORWARD_START_NUM = 4
private const val MOVE_FORWARD_COUNT = 1

class Racer(
    val count: Int = INIT_COUNT
) {
    fun run(num: Int): Racer {
        if (num >= MOVE_FORWARD_START_NUM) {
            return Racer(count + MOVE_FORWARD_COUNT)
        }
        return Racer(count)
    }
}
