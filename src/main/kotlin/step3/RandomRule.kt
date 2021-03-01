package step3

import kotlin.random.Random

class RandomRule: Rule {
    override fun isSatisfied(): Boolean {
        return Random.nextInt(10) >= 4
    }
}
