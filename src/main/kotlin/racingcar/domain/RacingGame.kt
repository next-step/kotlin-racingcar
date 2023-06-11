package racingcar.domain

import racingcar.view.InputView

/**
 * 자동차 게임 지휘자 객체
 */
class RacingGame {

    private val inputView: InputView = InputView()
    private val round: Round = Round()
    private val cars: ArrayList<Car> = ArrayList()

    fun start() {
        val (carNumber, roundNumber) = getInput()
        initCars(cars = cars, carNumber = carNumber)
        startEachRound(cars = cars, roundNumber = roundNumber)
    }

    private fun getInput(): Pair<Int, Int> {
        val carNumber = inputView.getCarNumber()
        val roundNumber = inputView.getRoundNumber()
        return Pair(carNumber, roundNumber)
    }

    private fun initCars(cars: ArrayList<Car>, carNumber: Int) {
        for (i in 0 until carNumber)
            cars.add(Car())
    }

    private fun startEachRound(cars: ArrayList<Car>, roundNumber: Int) {
        for (i in 0 until roundNumber) {
            round.execute(cars)
        }
    }
}
