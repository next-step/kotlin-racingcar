package racingcar.domain

import kotlin.random.Random

private const val MIN_CONDITION = 0
private const val MAX_CONDITION = 9

fun generateRandomCondition(): () -> Int = {
    Random.nextInt(MIN_CONDITION, MAX_CONDITION)
}
