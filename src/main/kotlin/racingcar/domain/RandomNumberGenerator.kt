package racingcar.domain

import kotlin.random.Random

object RandomNumberGenerator : NumberGenerator {
    override fun generate(from: Int, until: Int): Int {
        return Random.nextInt(from, until)
    }
}
