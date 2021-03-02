package racingcar_winner.model

import racingcar_winner.ui.Outputview

class Game(
    private val numberOfRound: Int,
    private val cars: Cars
) {
    private val numberOfCars: Int = cars.getNumberOfCars()
    private val randomNumberFactory = RandomNumberFactory()
    private val outputView = Outputview()

    fun playGame() {
        // 모든 차들은 한번씩 랜덤 값을 발생시킨다
        // 랜덤값이 4이상이면 전진한다.
        // 이 행동을 총 numberOfRound 만큼 반복한다.
        repeat(numberOfRound) {
            playOneRound()
            printOneRound()
        }
    }

    private fun playOneRound() {
        cars.playOneRound(randomNumberFactory)
    }

    private fun printOneRound() {
        val progressOfCars: Map<String, Int> = cars.getProgressOfCars()
        outputView.printOneRound(progressOfCars)
    }
}