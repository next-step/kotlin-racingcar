package racingcar.domain

class WinnerSelector(private val cars: MutableList<Car>) {
    private val winnerNames = mutableListOf<String>()

    fun selectWinner(): MutableList<String> {
        return assembleWinnerNames(pickFarthestPosition())
    }

    private fun pickFarthestPosition(): Int {
        var farthestPosition = 0
        for (nameOfCarsIndex in cars.indices) {
            farthestPosition = comparePosition(nameOfCarsIndex, farthestPosition)
        }
        return farthestPosition
    }

    private fun comparePosition(nameOfCarsIndex: Int, farthestPosition: Int): Int {
        if (cars[nameOfCarsIndex].position >= farthestPosition) {
            return cars[nameOfCarsIndex].position
        }
        return farthestPosition
    }

    private fun assembleWinnerNames(farthestPosition: Int): MutableList<String> {
        for (nameOfCarsIndex in cars.indices) {
            addWinnerNames(nameOfCarsIndex, farthestPosition)
        }
        return winnerNames
    }

    private fun addWinnerNames(nameOfCarsIndex: Int, farthestPosition: Int) {
        if (cars[nameOfCarsIndex].position == farthestPosition) {
            winnerNames.add(cars[nameOfCarsIndex].name)
        }
    }
}
