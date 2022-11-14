package study.racingcar.io

object OutputView {
    fun showResult(locationList: List<Int>) {
        locationList.forEach { location: Int ->
            printLineByLocation(location)
        }
        printEndOfTurn()
    }

    private fun printLineByLocation(location: Int) {
        return println("-".repeat(location))
    }

    private fun printEndOfTurn() {
        return println()
    }
}
