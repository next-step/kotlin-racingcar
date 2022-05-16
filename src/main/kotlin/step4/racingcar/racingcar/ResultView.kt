package step4.racingcar.racingcar

object ResultView {
    fun view(carList: List<Car>, moveCount: Int) {
        println(">>>>> 실행결과")
        repeat(moveCount) { round ->
            printRacingPerRound(carList, round)
        }
        printWinner(carList)
    }

    private fun printWinner(carList: List<Car>) {
        val maxMoveCount = carList.maxOf { car -> car.movements.count { it } }
        carList.filter { car -> car.movements.count { it } == maxMoveCount }.joinToString().also {
            println("[$it]가 최종 우승했습니다.")
        }
    }

    private fun printRacingPerRound(carList: List<Car>, round: Int) {
        println(">>>>> 시도 횟수 : ${round.plus(1)}")
        for (car in carList) {
            carMove(car, round)
            println()
        }
        println(">>>>>> 끝")
    }

    private fun carMove(car: Car, round: Int) {
        for (i in 0..round) {
            printRacerNameOrPass(i, car.racerName)
            printMovementOrPass(i, car.movements)
        }
    }

    private fun printRacerNameOrPass(index: Int, racerName: String) {
        if (index == 0) {
            print("$racerName : ")
        }
    }

    private fun printMovementOrPass(index: Int, movements: List<Boolean>) {
        if (movements[index]) {
            print("-")
        }
    }
}
