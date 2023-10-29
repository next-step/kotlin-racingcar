package racingcar.domain

import kotlin.random.Random

interface Rule {

    val carSize: Int
    val attemptSize: Int
    val moveOrNot: MoveOrNot?

    interface MoveOrNot {
        operator fun invoke(): Boolean = Random.nextInt(10) >= 4
    }
}
