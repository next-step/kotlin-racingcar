package racingcar.domain

import racingcar.view.ResultView

object Race {
    private var longestMovedDistance = 0
    private val winnerNameList = mutableListOf<String>()

    fun startRace(circuit: Circuit, numberOfTry: Int) {
        repeat(numberOfTry) {
            startLap(circuit)
            val lapResult = circuit.getAllCarsLapResult()
            ResultView.printResult(lapResult)
        }
    }

    fun getWinnerNameList(circuit: Circuit): List<String> {
        val lapResultList = circuit.getAllCarsLapResult()
        lapResultList.forEach {
            addToWinnerList(it)
        }
        setLongestMovedDistance(0)
        return winnerNameList.toList()
    }

    private fun startLap(circuit: Circuit) = circuit.tryToMoveAllCar()

    private fun addToWinnerList(lapResult: LapResult) {
        if (lapResult.isNotWinner(longestMovedDistance))
            return
        if (lapResult.isNewLongestMovedDistance(longestMovedDistance)) {
            winnerNameList.clear()
            setLongestMovedDistance(lapResult.movedDistance)
        }
        winnerNameList.add(lapResult.carName)
    }

    private fun setLongestMovedDistance(newLongestDistance: Int) {
        longestMovedDistance = newLongestDistance
    }
}
