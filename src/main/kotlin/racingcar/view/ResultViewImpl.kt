package racingcar.view

import racingcar.model.Car
import racingcar.model.InputResult

class ResultViewImpl : ResultView {
    override fun input(): InputResult {
        println("🚗자동차 경주 게임을 시작합니다\n")

        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val names = readlnOrNull()

        println("시도할 횟수는 몇 회인가요?")
        val turnCount = readlnOrNull()
        return InputResult(names, turnCount)
    }

    override fun printMessage(message: String) = println(message)

    override fun printTurn(turn: Int, cars: List<Car>) {
        println(if (turn == 1) "실행 결과" else "")
        cars.forEach {
            print("${it.name} : ")
            for (i in 0..it.position) {
                print("-")
            }
            println()
        }
    }

    override fun printResult(winner: String) {
        println("\n${winner}가 최종 우승했습니다.")
    }
}
