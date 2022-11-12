package racingcar.domain

import racingcar.view.InputView
import racingcar.view.ResultView
import kotlin.random.Random

const val RANDOM_MIN_NUM = 0
const val RANDOM_MAX_NUM = 9
const val RANDOM_CONDITION_NUM = 4

class Race(
    private val round: Int = 0
) : InputView, ResultView {

    fun make(): Race {
        val count = this.showQuestionAndGetInput("시도할 횟수는 몇 회인가요?").toInt()
        return Race(count)
    }

    fun run(cars: List<Car>) {
        for(i in 0 until this.round){
            cars.forEach { moveCar(it) }
            this.printListResult(cars.map { it.getRoute() })
        }
    }

    private fun moveCar(car: Car) {
        if(movingRule()) car.move()
    }

    private fun movingRule() = Random.nextInt(RANDOM_MIN_NUM, RANDOM_MAX_NUM) >= RANDOM_CONDITION_NUM

}
