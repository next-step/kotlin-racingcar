package racingcar.domain.car

@JvmInline
value class Count(
    private val count: Int = 0
) {

    fun toInt(): Int = count
    fun add() = Count(count + 1)
}
