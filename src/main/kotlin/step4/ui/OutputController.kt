package step4.ui

import step4.domain.CarDto

object OutputController {
    private const val PRINTING_SYMBOL = "-"

    fun output(results: List<List<CarDto>>, winners: List<CarDto>) {
        println("실행 결과")
        results.forEach { cars ->
            cars.forEach { car -> car.printCarStatus() }
            println()
        }

        println("${winners.joinToString { it.name }}가 최종 우승했습니다.")
    }

    private fun CarDto.printCarStatus() {
        print("$name : ${PRINTING_SYMBOL.repeat(this.position)}")
        println()
    }
}
