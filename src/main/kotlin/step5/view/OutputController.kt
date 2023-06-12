package step5.ui

import step5.domain.CarDto

object OutputController {
    private const val PRINTING_SYMBOL = "-"

    fun output(gameLogs: List<List<CarDto>>, winners: List<CarDto>) {
        println("실행 결과")
        gameLogs.forEach { logs ->
            logs.printLog()
            println()
        }

        println("${winners.joinToString { it.name }}가 최종 우승했습니다.")
    }

    private fun List<CarDto>.printLog() {
        this.forEach { car -> car.printNameAndPosition() }
    }

    private fun CarDto.printNameAndPosition() {
        print("$name : ${PRINTING_SYMBOL.repeat(this.position)}")
        println()
    }
}
