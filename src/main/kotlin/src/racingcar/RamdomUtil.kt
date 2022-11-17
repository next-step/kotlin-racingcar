package src.racingcar

import kotlin.random.Random
import kotlin.random.nextInt

private val RANDOM_NUMBER_RANGE = 0..9

fun getCarMoveRandomValue(): Int {
    return Random.nextInt(RANDOM_NUMBER_RANGE)
}
