package racingcar

class RacingCarGame(private val carCount: Int, private val trialCount: Int) {
    private val carList = List(carCount) { Car() }
    val gameResult
        get() = _gameResult.toList()
    private val _gameResult = mutableListOf<List<Int>>()

    fun play() = repeat(trialCount) {
        proceed()
        record()
    }

    private fun record() {
        val recordData = carList.map { it.position }
        _gameResult.add(recordData)
    }

    private fun proceed() = carList.forEach { it.proceed() }
}
