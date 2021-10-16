package racingcar.view

import racingcar.dto.ResultDto
import racingcar.dto.WinnersDto

class ResultView {
    fun printResultMessage() {
        println("\n실행 결과")
    }

    fun printResult(resultDto: ResultDto) {
        resultDto.result.entries.forEach(::print)
        println()
    }

    fun printWinners(winnersDto: WinnersDto) {
        print(winnersDto.winners.joinToString(", ") + "가 최종 우승했습니다.")
    }

    private fun print(entry: Map.Entry<String, Int>) {
        println(entry.key + " : " + "-".repeat(entry.value))
    }
}
