package racingCar

interface IDrawer {
    fun paint(carPositions: List<Int>): String
}

class Drawer: IDrawer {
    override fun paint(carPositions: List<Int>): String {
        return carPositions.joinToString(separator = "\n") { "-".repeat(it) }
    }
}