package step3.ui

import step3.domain.CarPositionList

object ResultInterface {
    private const val PRINTING_SYMBOL = "-"

    fun output(results: List<CarPositionList>) {
        println("실행 결과")
        results.forEach { result ->
            result.forEach { position -> position.printPositionStatus() }
            println()
        }
    }

    private fun Int.printPositionStatus() {
        PRINTING_SYMBOL.repeat(this).also(::print)
        println()
    }
}
