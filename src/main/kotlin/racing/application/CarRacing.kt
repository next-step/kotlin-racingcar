package racing.application

import racing.model.Car
import racing.model.Round

class CarRacing(private val carNames: List<String>, private val tries: Int) {

    companion object {
        const val GO_THRESHOLD_VALUE = 4
    }

    fun start(): Map<Int, Round> {
        val roundsMap = mutableMapOf<Int, Round>()
        repeat(tries) {
            val prevRound = roundsMap[it - 1]
            roundsMap[it] = doRound(it, prevRound)!!
        }
        return roundsMap
    }

    private fun doRound(roundNo: Int, prevRound: Round?): Round? {
        return if (isFirstRound(roundNo)) {
            getFirstRound(carNames)
        } else {
            getNextRound(prevRound)
        }
    }

    private fun isFirstRound(roundNo: Int): Boolean = roundNo == 0

    private fun getFirstRound(names: List<String>): Round =
        Round(names.map { Car(name = it) })

    private fun getNextRound(prevRound: Round?): Round? =
        prevRound?.next()
}
