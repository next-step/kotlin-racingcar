package racing

val INITIAL_POSITION = Position(0)

@JvmInline
value class Position(val value: Int) {

    init {
        require(value >= 0) { "Position은 0보다 크거나 같아야합니다." }
    }

    fun forward() = Position(value + 1)
}
