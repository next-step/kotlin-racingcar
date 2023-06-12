package racing.model

import racing.condition.RacingCondition
import racing.view.result.CarResultView

class RacingGame(carCount: Int, private val round: Int, private val conditions: List<RacingCondition>) {
    private val cars: List<Car>

    init {
        val cars = mutableListOf<Car>()
        for (i in 1..carCount) cars.add(Car())
        this.cars = cars
    }

    fun startRound(curRound: Int, carResultView: CarResultView) {
        cars.forEach { car ->
            car.doRacing(curRound, conditions)
            carResultView.render(car)
        }
        println()
    }

    fun startRacing(carResultView: CarResultView) {
        println("실행 결과")
        for (r in 1..round) startRound(r, carResultView)
    }
}
