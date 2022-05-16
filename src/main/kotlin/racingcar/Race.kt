package racingcar

class Race {
    fun start(carCount: Int, roundCount: Int): List<Round> {
        val carList = getCarList(carCount)
        val roundList = getRoundList(roundCount)
        for (currentRound in roundList) {
            carList.map {
                it.moveRandom()
            }

            currentRound.saveResult(carList)
        }

        return roundList
    }

    private fun getCarList(carCount: Int): List<Car> {
        return List(carCount) { Car() }
    }

    private fun getRoundList(roundCount: Int): List<Round> {
        return List(roundCount) { Round() }
    }
}
