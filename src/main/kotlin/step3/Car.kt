package step3

class Car {
    private val _record = mutableListOf<String>()
    val record: List<String>
        get() = _record

    fun run() {
        _record.add(moveOrStop())
    }

    fun getRecords(): String {
        return _record.joinToString(JOIN_CHARACTER_FOR_RECORD)
    }

    private fun moveOrStop(): String {
        val result = getRandomNumber()
        return if (result >= STANDARD_FOR_CAR_CAN_MOVE) MOVE else STOP
    }

    private fun getRandomNumber(): Int {
        val range = (RANDOM_RANGE_MIN..RANDOM_RANGE_MAX)
        return range.random()
    }

    companion object {
        private const val STANDARD_FOR_CAR_CAN_MOVE = 4
        private const val RANDOM_RANGE_MIN = 0
        private const val RANDOM_RANGE_MAX = 9

        private const val MOVE = "-"
        private const val STOP = ""

        private const val JOIN_CHARACTER_FOR_RECORD = ""
    }
}
