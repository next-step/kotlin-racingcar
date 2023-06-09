package racingcar

data class GameRecords(val records: IntArray) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameRecords

        if (!records.contentEquals(other.records)) return false

        return true
    }

    override fun hashCode(): Int {
        return records.contentHashCode()
    }
}
