package racinggame

data class RacingGameResult(
    val racingResult: List<PlayResult>
) : Result<List<List<String>>> {
    override fun translate() = racingResult.map { round ->
        round.translate()
    }
}

data class PlayResult(
    val result: List<Car>
) : Result<List<String>> {
    override fun translate() = result.map { car ->
        (0..car.position).map {
            "-"
        }.reduce { s1, s2 ->
            s1 + s2
        }.let {
            "${car.name} : $it"
        }
    }
}

data class PlayWinners(
    val winners: List<Car>
) : Result<String> {
    override fun translate() = winners.joinToString(", ") { car ->
        car.name
    }
}

interface Result<T> {
    fun translate(): T
}
