package racing.application

import racing.model.Rounds

class CarRacing(
    private val carNames: List<String>,
    private val tries: Int
) {

    companion object {
        private const val RANDOM_VALUE_FROM = 0
        private const val RANDOM_VALUE_UNTIL = 9

        fun getRandom(take: Int): List<Int> {
            return List(take) {
                (RANDOM_VALUE_FROM..RANDOM_VALUE_UNTIL).random()
            }
        }
    }

    fun start(): Rounds {
        val rounds = Rounds()
        return rounds.process(tries, carNames)
    }

}
