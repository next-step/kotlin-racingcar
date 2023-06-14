package racingcar.game

import racingcar.car.Car
import racingcar.car.MoveStrategy
import racingcar.car.RandomMoveStrategy
import java.util.Random

fun main() {
    val moveStrategy: MoveStrategy = RandomMoveStrategy(Random())
    val car: Car = Car(moveStrategy)
    GameView().printInputCarCountMessage()
    val carCount: Int = readln().toInt()
    GameView().printInputTryCountMessage()
    val tryCount: Int = readln().toInt()


    GameView().printResultMessage()
    for (i in 0 until tryCount) {
        car.move()
        GameView().printRacingResults(listOf(car))
    }
}
