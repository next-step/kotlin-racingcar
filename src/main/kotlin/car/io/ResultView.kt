package car.io

import car.business.Cars

class ResultView(val cars: Cars) {
    fun print() {
        for (currentPosition in cars.getPositions()) {
            printCarPosition(currentPosition)
        }
        println()
    }

    private fun printCarPosition(currentPosition: Int) {
        println("-".repeat(currentPosition))
    }
}
