package racingcar.domain

import racingcar.view.ResultView

class RacingCarGame(
    val gameInfo: GameInfo,
) {
    val cars: List<Car> = gameInfo.carInfo.names.map { name ->
        Car(name = name)
    }

    fun start() {
        showResultOfRounds(gameInfo.trialCount, cars)
        showWinner(cars)
    }

    private fun showResultOfRounds(trialCount: Int, cars: List<Car>) {
        ResultView.printResultMessage()
        repeat(trialCount) { round ->
            val resultOfRound = proceedRound(cars)
            ResultView.printTraceOfRound(round, resultOfRound)
        }
    }

    private fun proceedRound(cars: List<Car>): List<Car> {
        cars.forEach {
            it.action()
        }
        return cars
    }

    private fun showWinner(cars: List<Car>) {
        ResultView.printWinner(
            winner = Judges(cars).pickWinner()
        )
    }

    private fun pickWinner(max: Int, cars: List<Car>): List<Car> = cars.filter { car ->
        car.distance == max
    }
}
