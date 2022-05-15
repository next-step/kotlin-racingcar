package racingCar

class ResultView(
    private val Drawer: Drawer,
) {
    fun show(carPositions: List<Int>) = println(Drawer.paint(carPositions))
}