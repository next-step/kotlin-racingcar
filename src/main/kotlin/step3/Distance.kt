package step3

data class Distance(
    private val value: Int
) {
    init {
        require(value >= 0) { "이동 거리는 0 이상이어야 합니다." }
    }

    fun toInt(): Int {
        return value
    }

    infix operator fun plus(target: Distance): Distance {
        return Distance(this.value + target.value)
    }
}
