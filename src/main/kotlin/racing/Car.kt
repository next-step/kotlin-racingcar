package racing

class Car(val name: String, private val probability: Probability = Probability()) {
    var position = START_POSITION
        private set
    private val records = mutableListOf<Int>()

    fun tryGo() {
        if (probability.canGo())
            position++
        records.add(position)
    }

    fun getRecordByIndex(index: Int): Int {
        return records[index]
    }

    fun getRecordSize(): Int {
        return records.size
    }

    companion object {
        private const val START_POSITION = 1
    }
}
