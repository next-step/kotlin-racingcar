package racing

import racing.domain.CarNameMapper
import racing.domain.MoveCondition
import racing.domain.Racing
import racing.view.InputView

fun main() {
    val carNames = InputView.inputCarNames()
    val tryCount = InputView.inputTryCount()

    val cars = CarNameMapper.map(carNames)
    val racing = Racing(cars, tryCount)
    racing.startRacing { MoveCondition.movable() }
}
