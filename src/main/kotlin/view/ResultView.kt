package view

class ResultView {

    fun outputScreen(result: Pair<String, String>) {
        println(result.first)
        printWinner(result.second)
    }

    private fun printWinner(winners: String) {
        println("${winners}가 최종 우승했습니다.")
    }
}
