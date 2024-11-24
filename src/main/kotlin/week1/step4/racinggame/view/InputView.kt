package week1.step4.racinggame.view

import week1.step4.racinggame.domain.CarName

class InputView {
    companion object {
        fun inputCarNames(): List<CarName> {
            println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
            return readln().split(",").map { CarName(it.trim()) }
        }

        fun inputRound(): Int {
            println("시도할 횟수는 몇 회인가요?")
            return readln().toInt()
        }
    }
}
