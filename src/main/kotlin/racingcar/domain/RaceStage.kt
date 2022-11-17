package racingcar.domain

import racingcar.strategy.CarMoveStrategy

class RaceStage(
    val cars: List<Car>,
) {

    init {
        require(cars.isNotEmpty()) { "경주에 참여하는 자동차는 1개 이상이어야 합니다." }
    }

    companion object {
        fun create(carNames: List<String>): RaceStage = RaceStage(
            carNames.map { carName -> Car(carName) }
        )
    }

    fun racing(strategy: CarMoveStrategy): RaceStage = RaceStage(
        cars.map { car -> car.race(RacingCarEngine.canMove(strategy.generate())) }
    )

    fun getWinners(): List<Car> {
        val winnerCar = cars.findWinner()
        return cars.filter { it.isDraw(winnerCar) }
    }

    private fun List<Car>.findWinner(): Car = this.reduce { carA, carB -> if (carA.isWinner(carB)) carA else carB }
}
