package racing

import racing.domain.CarFactory
import racing.domain.CarRacing
import racing.view.RacingInputReceiver
import racing.view.RacingUI

fun main() {

    val input = RacingInputReceiver.receive()

    val carFactory = CarFactory()

    CarRacing.run(
        cars = carFactory.createCars(input.carNames),
        moveCount = input.moveCount,
        onStart = { RacingUI.drawCars(it) },
        onTurnEnd = { RacingUI.drawCars(it) },
        onFinish = { RacingUI.drawWinners(it) }
    )
}
