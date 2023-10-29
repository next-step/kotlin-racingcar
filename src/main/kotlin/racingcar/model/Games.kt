package racingcar.model

import racingcar.view.OutputView

data class Games(
    private val gameCount: Int,
    private val dashboard: OutputView,
    private val moveStrategy: MoveStrategy,
) {
    fun play(cars: Cars) {
        dashboard.printHeader()

        repeat(gameCount) {
            dashboard.showProgress(cars.move(moveStrategy))
        }
    }

    companion object {
        fun of(gameCount: Int, dashboard: OutputView, numberGenerator: NumberGenerator): Games {
            return Games(gameCount, dashboard, MoveStrategy(numberGenerator))
        }
    }
}
