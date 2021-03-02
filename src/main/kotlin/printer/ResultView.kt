package printer

object ResultView {
    fun printInt() {
        println("실행 결과")
    }

    fun printRacing(carPositions: List<List<Int>>) {
        carPositions.map { carPosition ->
            printCarsPath(carPosition)
            println()
        }
    }

    private fun printCarsPath(positions: List<Int>) {
        positions.forEach { position -> printCarPath(position) }
    }

    private fun printCarPath(position: Int) {
        println("-".repeat(position))
    }
}
