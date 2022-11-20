package race

class Record private constructor(
    val raceRecord: HashMap<Int, MutableList<Boolean>>
) {

    fun record(carIndex: Int, movement: Boolean) {
        raceRecord[carIndex]?.add(movement)
    }

    companion object {
        fun from(carCount: Int): Record {
            val recordRace = HashMap<Int, MutableList<Boolean>>()
            repeat(carCount) {
                recordRace[it] = mutableListOf()
            }
            return Record(recordRace)
        }
    }
}
