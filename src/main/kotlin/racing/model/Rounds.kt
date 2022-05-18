package racing.model

import racing.application.CarRacing

class Rounds() {
    private val roundMap = mutableMapOf<Int, Round>()

    fun process(tries: Int, carNames: List<String>): Rounds {
        repeat(tries) {
            val prevRound = get(it - 1)
            val numberOfCars = carNames.size
            put(
                it,
                getNextRound(
                    prevRound,
                    CarRacing.getRandom(numberOfCars),
                    numberOfCars,
                    carNames
                )
            )
        }
        return this
    }

    private fun getNextRound(
        prevRound: Round?,
        randomNumbers: List<Int>,
        numberOfCars: Int,
        carNames: List<String>
    ): Round =
        prevRound?.next(randomNumbers) ?: getFirstRound(numberOfCars, carNames)

    private fun getFirstRound(numberOfCars: Int, carNames: List<String>): Round =
        Round(List(numberOfCars) { Car(carNames[it]) })

    fun put(roundNo: Int, round: Round) {
        roundMap[roundNo] = round
    }

    fun get(roundNo: Int): Round? {
        return roundMap[roundNo]
    }
}