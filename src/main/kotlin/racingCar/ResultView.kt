package racingCar

class ResultView(private val Drawer: IDrawer) {
    fun show(carPositions: List<Int>) {
        println("RaceGame 결과: ")
        Drawer.paintFor(convertDataToView(carPositions))
    }

    private fun convertDataToView(carPositions: List<Int>): String {
        return carPositions.joinToString(separator = "\n") { "-".repeat(it) }
    }
}