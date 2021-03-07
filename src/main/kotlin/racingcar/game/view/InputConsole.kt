package racingcar.game.view

import racingcar.game.vo.GameParameter

object InputConsole {
    fun run(): GameParameter {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val nameOfCar = readLine()

        println("시도할 횟수는 몇 회인가요?")
        val numOfGame: String? = readLine()

        return GameParameter.initParameter(nameOfCar, numOfGame)
    }
}
