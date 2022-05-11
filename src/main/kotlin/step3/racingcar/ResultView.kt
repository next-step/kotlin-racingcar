package step3.racingcar

object ResultView {
    fun view(carList: List<Car>, moveCount: Int) {
        repeat(moveCount) { round ->
            for (car in carList) {
                carMove(car, round)
                println()
            }
            println()
        }
    }

    private fun carMove(car: Car, round: Int) {
        for (i in 0..round) {
            if (car.movements[i]) {
                print("-")
            }
        }
    }
}
