package racingcar.car

class ResultView {
    companion object {
        fun printResult(cars: Cars) {
            println("printResult")
            for (car in cars) {
                printDash(car.point)
            }
            println()
        }

        fun printDash(x: Int) {
            for (x in 0..x) {
                print("-")
            }
            println()
        }
    }
}
