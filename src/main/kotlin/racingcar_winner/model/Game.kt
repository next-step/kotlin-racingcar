package racingcar_winner.model

import racingcar_winner.ui.Outputview

class Game(
    private val numberOfRound: Int,
    private val carNames: List<String>
) {
    private val cars: Cars = Cars.makeCars(Cars.convertNamesToCar(carNames))
    private val randomNumberFactory = RandomNumberManager()
    private val recorder = Recorder()

    fun playGame() {
        repeat(numberOfRound) {
            cars.moveAll(randomNumberFactory)
            recorder.recordCurrentState(cars)
        }
    }

    fun getGameRecord(): String = recorder.record

    fun getGameWinner(): List<String> = Winner(cars).getWinner()
}
