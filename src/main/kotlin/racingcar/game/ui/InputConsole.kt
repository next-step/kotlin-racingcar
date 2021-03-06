package racingcar.game.ui

import racingcar.game.domain.Game
import racingcar.game.vo.GameParameter

class InputConsole() {
    fun run(): Game {
        print("자동차 대수는 몇 대인가요?")
        val numOfCar = readLine()
        print("시도할 횟수는 몇 회인가요?")
        val numOfGame: String? = readLine()
        return Game(GameParameter(numOfCar, numOfGame))
    }
}
