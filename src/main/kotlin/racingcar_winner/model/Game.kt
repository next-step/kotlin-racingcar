package racingcar_winner.model

class Game(
    private val carNames: List<String>
) {
    private val cars: Cars = Cars.makeCars(Cars.convertNamesToCar(carNames))
    private val randomNumberFactory = RandomNumberManager()

    fun playOneRound(): Cars {
        cars.moveAll(randomNumberFactory)
        return cars
    }

    fun getGameWinner(): List<String> = Winner(cars).getWinner()
}
