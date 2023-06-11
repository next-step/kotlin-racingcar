package racingcar.view

import racingcar.model.Car
import racingcar.model.InputResult
import java.lang.IllegalStateException

class ResultViewImpl : ResultView {
    override fun input(): InputResult {
        println("🚗자동차 경주 게임을 시작합니다\n")

        println("자동차 대수는 몇 대인가요?")
        val carCount = readlnOrNull()?.toIntOrNull() ?: throw IllegalStateException("정수 값을 입력해주세요")

        println("시도할 횟수는 몇 회인가요?")
        val turnCount = readlnOrNull()?.toIntOrNull() ?: throw IllegalStateException("정수 값을 입력해주세요")
        return InputResult(carCount, turnCount)
    }

    override fun output(carList: List<Car>) {
        println("실행 결과")
        carList.forEach {
            for (i in 0..it.position) {
                print("-")
            }
            println()
        }
    }
}
