package racingcar.domain

class WinnerSelector(private val cars: List<Car>) {

    fun selectWinnerName(): List<String> {
        val names = mutableListOf<String>()
        val winners = selectWinnerCar()
        for (car in winners) {
            names.add(car.name)
        }
        return names
    }

    private fun selectWinnerCar(): List<Car> {
        return cars.filter { it.position == pickWinnerPosition() }
    }

    private fun pickWinnerPosition(): Int {
        var winnerPosition = 0
        for (nameOfCarsIndex in cars.indices) {
            winnerPosition = comparePosition(nameOfCarsIndex, winnerPosition)
        }
        return winnerPosition
    }

    private fun comparePosition(nameOfCarsIndex: Int, winnerPosition: Int): Int {
        if (cars[nameOfCarsIndex].position >= winnerPosition) {
            return cars[nameOfCarsIndex].position
        }
        return winnerPosition
    }
}
