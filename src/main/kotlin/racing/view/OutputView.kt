package racing.view

import racing.domain.Name

class OutputView {
    fun printResultString() {
        println("실행 결과")
    }

    fun printResult(results: List<Pair<Name, Int>>) {
        results.map { it.first.name + " : " + "-".repeat(it.second) }.forEach(::println)
        println()
    }

    fun printWinners(winners: List<Name>) {
        println(winners.map { it.name }.reduce { n1, n2 -> "$n1,$n2" } + "가 최종 우승했습니다.")
    }
}
