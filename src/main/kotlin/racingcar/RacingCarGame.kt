package racingcar

class RacingCarGame(private val carCount: Int, private val trialCount: Int) {
    private val carList = mutableListOf<Car>()
    val gameResult = mutableListOf<List<Int>>()

    fun prepare() {
        for (i in 0 until carCount) {
            carList.add(Car())
        }
    }

    fun play() {
        for (c in 0 until trialCount) {
            proceed()

            record()
        }
    }

    private fun record() {
        val recordData = carList.map { it.position }
        gameResult.add(recordData)
    }

    private fun proceed() = carList.forEach { it.proceed() }
}
