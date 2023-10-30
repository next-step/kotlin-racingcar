package racinggame

data class RacingGameResult(
    val racingResult: List<PlayResult>
) : Result<List<String>> {
    override fun translate() = racingResult.map { round ->
        round.translate()
    }
}

data class PlayResult(
    val result: List<Int>
) : Result<String> {
    override fun translate() = result.map {
        (0..it).map {
            "-"
        }.reduce { s1, s2 ->
            s1 + s2
        }
    }
}

interface Result<T> {
    fun translate(): List<T>
}
