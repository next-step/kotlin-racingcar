package study.racinggame.domain

import kotlin.random.Random

class RaceRule(
    private val random: Random = Random,
    private val randomBound: Int = DEFAULT_RANDOM_BOUND,
    private val forwardThreshold: Int = DEFAULT_FORWARD_THRESHOLD
) {
    init {
        require(forwardThreshold < randomBound) { "randomBound: ${randomBound}가 forwardThreshold${forwardThreshold}보다 작을 수는 없습니다." }
    }

    fun canMove(): Boolean {
        return random.nextInt(randomBound) > forwardThreshold
    }

    companion object {
        private const val DEFAULT_RANDOM_BOUND = 10
        private const val DEFAULT_FORWARD_THRESHOLD = 3
    }
}
