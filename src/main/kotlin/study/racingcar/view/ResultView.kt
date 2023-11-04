package study.racingcar.view

class ResultView(private val outputReceiver: OutputReceiver) {

    fun startDisplayResult() {
        outputReceiver.receive("실행 결과")
    }

    fun displayRound(carList: List<Pair<String, Int>>) {
        val result = carList.joinToString("\n") { (name, position) ->
            "$name : " + "-".repeat(position)
        } + "\n"
        outputReceiver.receive(result)
    }

    fun displayWinners(winnerNames: List<String>) {
        outputReceiver.receive("${winnerNames.joinToString(", ")} 가 최종 우승했습니다.")
    }
}
