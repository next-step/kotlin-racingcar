package carRacing

import kotlin.random.Random


object RaceRule {
    val over4CanGo = { Random.nextInt(0, 10) in 4 until 10 }
}

typealias RaceRuleType = () -> Boolean
