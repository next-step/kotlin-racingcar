package racingcar

fun main() {
    val (carCount, tryCount) = InputView.view()
    // carCount = 3, tryCount = 5 일때 각 자동차의 positionHistory를 기록한 리스트를 갖는 리스트를 리턴
    // result = [[1,2,3,3,3],[0,1,2,3,3],[1,1,1,1,2]]
    val result = RacingCar.race(carCount, tryCount)
    ResultView.view(result)
}

object InputView {
    fun view(): Pair<Int, Int> {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readLine()!!.toInt()
        println("시도할 횟수는 몇 회인가요?")
        val tryCount = readLine()!!.toInt()
        return carCount to tryCount
    }
}

object ResultView {
    fun view(result: MutableList<List<Int>>) {
        for (i in 0..result[0].size - 1) {
            for (j in 0..result.size - 1) {
                printResult(result[j][i])
            }
            println()
        }
    }

    private fun printResult(value: Int) {
        for (i in 1..value) {
            print("-")
        }
        println()
    }
}

object RacingCar {
    fun race(carCount: Int, tries: Int): MutableList<List<Int>> {
        val cars = mutableListOf<List<Int>>()
        for (i in 1..carCount) {
            cars.add(Car().moveForward(tries))
        }
        return cars
    }

    class Car {
        fun moveForward(tries: Int): List<Int> {
            val positionHistory = mutableListOf<Int>()
            var distance = 0
            for (i in 1..tries) {
                if (canMove()) distance++
                positionHistory.add(distance)
            }
            return positionHistory
        }

        private fun canMove(): Boolean {
            val randomValue = (0..9).random()
            return randomValue >= 4
        }
    }
}
