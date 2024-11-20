package racingcar

class PhaseResultRow {
    private val row = mutableListOf<Int>()

    fun addResult(result: Int) {
        row.add(result)
    }

    fun getPhaseRecord(phase: Int): Int {
        return row[phase]
    }

    fun getMax(): Int {
        return row.max()
    }
}
