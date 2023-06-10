package racing

import kotlin.random.Random

class RandomNumberForwardCondition : ForwardCondition {

    override fun getForwardCondition(): Boolean {
        return random.nextInt(MAX_FORWARD_CONDITION) >= MIN_FORWARD_CONDITION
    }

    companion object {
        private const val MIN_FORWARD_CONDITION = 4
        private const val MAX_FORWARD_CONDITION = 10

        private val random = Random
    }
}
