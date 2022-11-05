package racing.domain

class RacingGame(carCount: Int, tryCount: Int) {
    private var cars: Cars = Cars(carCount)
    private var rounds: Rounds = Rounds(tryCount)
    private var result: Result = Result()

    fun play(): Result {
        while (rounds.hasNext()) {
            cars = rounds.play(cars)
            result.add(cars)
        }

        return result
    }
}
