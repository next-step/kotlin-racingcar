package racingCar

class ResultView(
    private val carPositions: List<Int>,
    private val Drawer: Drawer,
) {
    fun show() = println(Drawer.paint(carPositions))
}