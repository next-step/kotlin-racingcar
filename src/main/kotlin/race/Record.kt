package race

class Record private constructor(
    val raceRecords: HashMap<String, MutableList<Boolean>>
) {

    fun record(carName: String, movement: Boolean) {
        raceRecords[carName]?.add(movement)
    }

    fun getWinnerCarName(): List<String> {
        val maxCount = raceRecords.values.maxOfOrNull { raceResult -> raceResult.count { it } } ?: 0
        return raceRecords.filterValues { raceRecord -> raceRecord.count { it } == maxCount }.keys.toList()
    }

    companion object {
        fun from(carNames: List<String>): Record {
            val recordRace = HashMap<String, MutableList<Boolean>>()
            carNames.forEach {
                recordRace[it] = mutableListOf()
            }
            return Record(recordRace)
        }
    }
}
