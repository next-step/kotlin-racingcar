package step3.ui

object ResultInterface {
    private const val PRINTING_SYMBOL = "-"

    fun output(result: List<List<Int>>) {
        println("실행 결과")
        result.forEach {
            it.forEach { position -> position.printPositionStatus() }
            println()
        }
    }

    private fun Int.printPositionStatus() {
        PRINTING_SYMBOL.repeat(this).also(::print)
        println()
    }
}
