package car.io

import car.business.Cars

class ResultView(val cars: Cars) {
    fun print() {
        for(i in cars.getPositions()) {
            printDash(i)
            println()
        }
        println()
    }

    private fun printDash(count: Int) {
        for(i in 0 .. count) {
            print("-")
        }
    }
}