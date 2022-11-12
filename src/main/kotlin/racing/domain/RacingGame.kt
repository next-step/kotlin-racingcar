package racing.domain

class RacingGame(
    private var cars: Cars,
    private val rounds: Rounds
) {
    constructor(carCount: Int, tryCount: Int) : this(Cars(carCount), Rounds(tryCount))

    fun play(): Result {
        var result = Result()
        while (rounds.hasNext()) {
            rounds.play()
            result.add(cars.move())
        }

        return result
    }
}
