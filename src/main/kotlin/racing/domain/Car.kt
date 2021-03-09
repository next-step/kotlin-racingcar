package racing.domain

import java.util.Collections

class Car(val name: String, private val probability: Probability = Probability()) {
    var position = START_POSITION
        private set
    private val records = mutableListOf<Int>()

    fun tryGo() {
        if (probability.canGo())
            position++
        records.add(position)
    }

    fun getRecords(): List<Int> {
        return Collections.unmodifiableList(records)
    }

    companion object {
        private const val START_POSITION = 1
    }
}
