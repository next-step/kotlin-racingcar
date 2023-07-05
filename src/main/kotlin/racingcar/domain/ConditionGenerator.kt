package racingcar.domain

import kotlin.random.Random
import kotlin.random.nextInt

interface ConditionGenerator {
    fun generate(): Int {
        return Random.nextInt(0..9)
    }
}
