package step3

class RacingGame {
    private val _carList = mutableListOf<Car>()
    val carList: List<Car>
        get() = _carList

    private val _records = mutableMapOf<Car, MutableList<String>>()
    val records: Map<Car, List<String>>
        get() = _records

    fun play(cars: Int, times: Int) {
        repeat(times) {
            repeat(cars) {
                if (_carList.getOrNull(it) == null) _carList.add(it, Car())
                val car = _carList[it]
                val record = _records.getOrPut(car) { mutableListOf() }
                record.add(car.moveOrStop(getRandomNumber()))
                ResultView().printRacingResult(record.joinToString(JOIN_CHARACTER_FOR_RECORD))
            }
            ResultView().printNextRacing()
        }
    }

    private fun getRandomNumber(): Int {
        val range = (RANDOM_RANGE_MIN..RANDOM_RANGE_MAX)
        return range.random()
    }

    companion object {
        private const val RANDOM_RANGE_MIN = 0
        private const val RANDOM_RANGE_MAX = 9
        private const val JOIN_CHARACTER_FOR_RECORD = ""
    }
}
