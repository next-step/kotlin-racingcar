package racingcar.view

import racingcar.dto.ResultDto

class ResultView {
    fun printResultMessage() {
        println("\n실행 결과")
    }

    fun print(resultDto: ResultDto) {
        resultDto.positions.forEach(::print)
        println()
    }

    private fun print(position: Int) {
        println("-".repeat(position))
    }
}
