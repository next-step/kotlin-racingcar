package racingame.domain

import java.util.Random

class RandomNumberGenerator : NumberGenerator {
    private val randomNumber: Int
        get() = Random().nextInt(MAX)

    override fun generate(): Int {
        return randomNumber
    }

    companion object {
        private const val MAX = 10
    }
}
