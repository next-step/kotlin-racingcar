package view

import model.Race

class ResultView {
    private val mark = "-"

    fun showResult(record: List<Race.Record>) {
        display(record)
        println()
    }

    private fun display(result: List<Race.Record>) {
        result.forEach {
            println("${it.name}: ${mark.repeat(it.distance)}")
        }
    }

    fun whoIsWinner(result: List<Race.Record>) {
        val maxDistance = result.maxOf { it.distance }
        val winnersName = result.filter { it.distance == maxDistance }
            .map { it.name }

        println("${winnersName.list()}가 최종 우승했습니다.")
    }

    private fun List<String>.list() = this.reduce { first, next -> "$first, $next" }
}
