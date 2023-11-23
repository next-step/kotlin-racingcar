package racingcar

import racingcar.domain.CarInputProvider
import racingcar.domain.CarResultProvider
import racingcar.view.ConsoleCarInputView
import racingcar.view.ConsoleCarResultView

object DependencyConfig {
    val carInputProvider: CarInputProvider = ConsoleCarInputView()

    val outputProvider: CarResultProvider = ConsoleCarResultView()

    val moveStrategy: MoveStrategy = RandomMoveStrategy()
}
