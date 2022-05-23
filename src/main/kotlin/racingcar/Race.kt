package racingcar

class Race {
    fun result(carNames: List<String>, roundCount: Int): List<Round> {
        val carList = getCarList(carNames)
        val roundList = getRoundList(roundCount)

        for (currentRound in roundList) {
            carList.map {
                it.move()
            }

            currentRound.saveResult(carList)
        }

        return roundList
    }

    private fun getCarList(carNames: List<String>): List<Car> {
        return List(carNames.size) { i -> Car(carNames[i]) }
    }

    private fun getRoundList(roundCount: Int): List<Round> {
        return List(roundCount) { Round() }
    }
}
