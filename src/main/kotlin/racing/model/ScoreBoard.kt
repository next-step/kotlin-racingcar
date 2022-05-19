package racing.model

class ScoreBoard(private val history: List<Cars>) : List<Cars> by history {

    init {
        require(history.isNotEmpty())
    }
}
