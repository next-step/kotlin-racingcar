package racingcar.model

data class GameCount(val count: Int) {

    init {
        require(count > 0) { "at least 1 count required" }
    }

    override fun toString(): String = count.toString()
}

inline fun repeat(count: GameCount, action: (Int) -> Unit) = repeat(count.count, action)
