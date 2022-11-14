package racingcar.domain

import racingcar.ForwardStrategy

class RacingGame(
    private val cars: List<Car>,
    private val forwardStrategy: ForwardStrategy
) {

    init {
        require(cars.isNotEmpty()) { "최소 하나의 자동차가 필요합니다." }
    }

    constructor(forwardStrategy: ForwardStrategy, carNames: List<String>) : this(
        cars = carNames.map { Car(it) },
        forwardStrategy = forwardStrategy
    )

    fun play(playCount: Int, printCars: (List<Car>) -> Unit = {}): List<String> {
        require(playCount >= 0) { "실행 횟수는 양수로 입력해주세요." }

        val finishedRacingCars = this.race(this.cars, playCount, printCars)
        return Rank.getWinnerNames(finishedRacingCars)
    }

    private tailrec fun race(cars: List<Car>, playCount: Int, printCars: (List<Car>) -> Unit): List<Car> {
        if (playCount == 0) return cars

        val movedCars = this.move(cars)
        printCars(movedCars)

        return this.race(movedCars, playCount.dec(), printCars)
    }

    private fun move(cars: List<Car>): List<Car> =
        cars.map { car ->
            car.move(this.forwardStrategy.generateInt())
        }
}
