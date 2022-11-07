package racing

import racing.car.Car
import racing.view.GameInputView

fun main(args: Array<String>) {
    val game = GameInputView().inputRacingGameInfo()

    var car = Car(4, 0)
    // car.go()
}
