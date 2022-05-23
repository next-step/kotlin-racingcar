package racingcar

class Race {
    fun result(carCount: Int, roundCount: Int): List<Round> {
        val carList = getCarList(carCount)
        val roundList = getRoundList(roundCount)

        for (currentRound in roundList) {
            carList.map {
                it.move()
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
