package racing.application

import racing.model.Car
import racing.model.Round

class CarRacing(private val numberOfCars: Int, private val tries: Int) {

    companion object {
        private const val RANDOM_VALUE_FROM = 0
        private const val RANDOM_VALUE_UNTIL = 9

        fun getRandom(take: Int): List<Int> {
            return List(take) {
                (RANDOM_VALUE_FROM..RANDOM_VALUE_UNTIL).random()
            }
        }
    }

    fun start(): Map<Int, Round> {
        val roundsMap = mutableMapOf<Int, Round>()
        repeat(tries) {
            val prevRound = roundsMap[it - 1]
            roundsMap[it] = getNextRound(prevRound, getRandom(numberOfCars), numberOfCars)
        }
        return roundsMap
    }

    private fun getFirstRound(numberOfCars: Int): Round =
        Round(List(numberOfCars) { Car() })

    private fun getNextRound(prevRound: Round?, randomNumbers: List<Int>, numberOfCars: Int): Round =
        prevRound?.next(randomNumbers) ?: getFirstRound(numberOfCars)
}