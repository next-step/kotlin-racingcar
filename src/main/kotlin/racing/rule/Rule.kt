package racing.rule

import kotlin.random.Random

class Rule : RuleInterface {
    override fun isMove(): Boolean = Random.nextInt(RANDOM_CONDITION) > TURE_CONDITION

    companion object {
        private const val TURE_CONDITION = 4
        private const val RANDOM_CONDITION = 9
    }
}
