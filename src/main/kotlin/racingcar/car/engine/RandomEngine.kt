package racingcar.car.engine

private val RANDOM_RANGE = (0..9)
private const val DATUM_POINT = 4
private const val FORWARD_POINT = 1
private const val STOP_POINT = 0

class RandomEngine : Engine {
    override fun advancePoint(): Int =
        if (RANDOM_RANGE.random() >= DATUM_POINT) FORWARD_POINT
        else STOP_POINT
}
