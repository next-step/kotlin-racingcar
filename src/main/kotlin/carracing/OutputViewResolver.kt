package carracing

class OutputViewResolver {

    fun makeCarPositionsView(positions: List<Int>): StringBuilder {
        val carPositionView = "-"
        val carPositionsView = StringBuilder()
        for (position in positions) {
            carPositionsView.append(carPositionView.repeat(position))
            carPositionsView.append("\n")
        }
        return carPositionsView
    }
}