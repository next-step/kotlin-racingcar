package racing.domain

class RacingGame(
    private var cars: Cars,
    private val rounds: Rounds
) {
    constructor(carNames: String, tryCount: Int) : this(Cars(carNames), Rounds(tryCount))

    fun play(): Result {
        val result = Result()
        while (rounds.hasNext()) {
            rounds.play()
            result.add(cars.move())
        }

        return result
    }
}
