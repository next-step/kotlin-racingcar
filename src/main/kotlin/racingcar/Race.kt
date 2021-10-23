package racingcar

object Race {
    private var longestMovedDistance = 0
    private fun LapResult.isNotWinner() = movedDistance < longestMovedDistance
    private fun LapResult.isNewLongestMovedDistance() = movedDistance > longestMovedDistance
    fun startLap(circuit: Circuit) {
        circuit.tryToMoveAllCar()
    }

    fun getWinnerNameList(circuit: Circuit): List<String> {
        val lapResultList = circuit.getAllCarsLapResult()
        val winnerNameList = mutableListOf<String>()
        lapResultList.forEach {
            addToWinnerList(it, winnerNameList)
        }
        setLongestMovedDistance(0)
        return winnerNameList.toList()
    }

    private fun addToWinnerList(lapResult: LapResult, winnerNameList: MutableList<String>) {
        if (lapResult.isNotWinner())
            return
        if (lapResult.isNewLongestMovedDistance()) {
            winnerNameList.clear()
            setLongestMovedDistance(lapResult.movedDistance)
        }
        winnerNameList.add(lapResult.carName)
    }

    private fun setLongestMovedDistance(newLongestDistance: Int) {
        longestMovedDistance = newLongestDistance
    }
}
