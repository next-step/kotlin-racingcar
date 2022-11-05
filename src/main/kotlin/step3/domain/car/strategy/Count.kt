package step3.domain.car.strategy

class Count(
    private var count: Int = 0
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Count

        if (count != other.count) return false

        return true
    }

    override fun hashCode(): Int {
        return count
    }

    fun toInt(): Int = count
    fun add() = Count(count + 1)
}
