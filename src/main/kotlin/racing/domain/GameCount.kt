package racing.domain

@JvmInline
value class GameCount(private val count: Int) {
    companion object {
        private const val GAME_END_COUNT = 0
    }

    fun downCount(): GameCount {
        return GameCount(count - 1)
    }

    val isLeft: Boolean
        get() = count > GAME_END_COUNT
}
