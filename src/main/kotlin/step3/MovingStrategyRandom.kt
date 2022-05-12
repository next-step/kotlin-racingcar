package step3

import java.util.Random

class MovingStrategyRandom : MovingStrategy {
    companion object {
        private const val RANGE = 10
        private const val RESTRICT = 4
    }

    override fun movable(): Boolean {
        return randomNumber() >= RESTRICT
    }

    private fun randomNumber() : Int {
        val random = Random()
        return random.nextInt(RANGE)
    }
}

