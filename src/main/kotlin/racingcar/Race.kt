package racingcar

class Race {
    var carList = listOf<Car>()
        private set
    var roundList = listOf<Round>()
        private set

    fun start(carCount: Int, roundCount: Int) {
        setData(carCount, roundCount)

        for (currentRound in roundList) {
            carList.map {
                it.moveRandom()
            }

            currentRound.saveResult(carList)
        }
    }

    private fun setData(carCount: Int, roundCount: Int) {
        carList = getCarList(carCount)
        roundList = getRoundList(roundCount)
    }

    private fun getCarList(carCount: Int): List<Car> {
        return List(carCount) { Car() }
    }

    private fun getRoundList(roundCount: Int): List<Round> {
        return List(roundCount) { Round() }
    }
}
