package racing.ui

class ResultView {

    companion object {

        fun printRacingGameGuideText() {
            println("실행결과")
        }
        fun printRacingGameResult(result: String) {
            println(result)
        }

        fun printRacingGameWinner(winner: String) {
            println("${winner}가 최종 우승했습니다.")
        }
    }
}
