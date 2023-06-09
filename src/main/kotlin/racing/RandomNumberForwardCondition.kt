package racing

import java.util.Random

class RandomNumberForwardCondition : ForwardCondition {

    companion object {
        private const val MIN_FORWARD_CONDITION = 4
        private const val MAX_FORWARD_CONDITION = 10

        private val random = Random()
    }

    override fun getForwardCondition(): Boolean {
        return random.nextInt(MAX_FORWARD_CONDITION) >= MIN_FORWARD_CONDITION
    }
}
