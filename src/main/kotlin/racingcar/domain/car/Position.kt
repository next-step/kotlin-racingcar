package racingcar.domain.car

@JvmInline
value class Position(
    private val position: Int = 0
) {

    fun forward() = Position(this.position + 1)

    fun toInt() = position
}
