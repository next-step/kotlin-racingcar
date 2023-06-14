package study.step3.io

import study.step3.Scoreboard

class Output {

    fun showInputNumberOfCar() {
        println("자동차 대수는 몇 대 인가요?")
    }

    fun showInputNumberOfRound() {
        println("시도할 회수는 몇 회 인가요?")
    }

    fun showResult(scoreboard: Scoreboard) {
        scoreboard.show("실행 결과")
    }
}
