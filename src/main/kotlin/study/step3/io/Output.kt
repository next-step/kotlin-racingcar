package study.step3.io

import study.step3.Scoreboard

class Output {

    fun showInputCarNames() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun showInputNumberOfRound() {
        println("시도할 회수는 몇 회 인가요?")
    }

    fun showResult(scoreboard: Scoreboard) {
        scoreboard.show("실행 결과")
    }
}
