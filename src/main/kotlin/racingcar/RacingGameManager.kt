package racingcar

import racingcar.strategy.MovingStrategy
import racingcar.strategy.Strategy
import racingcar.ui.InputView
import racingcar.ui.ResultView
import java.util.function.Consumer

class RacingGameManager(builder: Builder) {

    private val car by lazy { List(builder.inputView.numOfCar) { Car(mutableListOf(1), builder.strategy) } }
    private val repetition: Int by lazy { builder.inputView.numOfRepetition }
    private val resultView by lazy { builder.resultView }

    fun racing(finish: Consumer<Unit>) {
        repeat(repetition) {
            car.forEach(Car::run)
        }
        finish.accept(Unit)
    }

    fun showRacingResult() {
        resultView.showMessage(ResultView.TITLE_RACING_RESULT)
        repeat(repetition) { step ->
            car.forEach {
                resultView.showMessage(resultView.draw(it.position[step]))
            }
            resultView.showMessage(resultView.getFinishStepTitle(step))
        }
    }

    class Builder(val inputView: InputView, val resultView: ResultView) {
        var strategy: Strategy = MovingStrategy()

        fun build() = RacingGameManager(this)

        fun strategy(strategy: Strategy): Builder {
            this.strategy = strategy
            return this
        }
    }

    companion object {
        fun builder(inputView: InputView, resultView: ResultView) = Builder(inputView, resultView)
    }
}
