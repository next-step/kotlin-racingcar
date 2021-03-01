package car.io

import car.business.Cars

class ResultView(val cars: Cars) {
    fun print() {
        for (i in cars.getPositions()) {
            printCarPosition(i)
        }
        println()
    }

    private fun printCarPosition(count: Int) {
        for (i in 0..count) {
            print("-")
        }
        println()
    }
}
