package step3

class RacingGame(private val carList: List<Car>, private val times: Int) {
    private val _records = mutableMapOf<Car, MutableList<String>>()
    val records: Map<Car, List<String>>
        get() = _records

    fun play() {
        repeat(times) {
            carList.forEach { car ->
                val record = _records.getOrPut(car) { mutableListOf() }
                record.add(car.moveOrStop(getRandomNumber()))
            }
            ResultView().printRacingResult(records)
        }
    }

    private fun getRandomNumber(): Int {
        val range = (RANDOM_RANGE_MIN..RANDOM_RANGE_MAX)
        return range.random()
    }

    companion object {
        private const val RANDOM_RANGE_MIN = 0
        private const val RANDOM_RANGE_MAX = 9
    }
}
