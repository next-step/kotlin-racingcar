package racingcar

class InputView {
    fun view(): Pair<Int, Int> {
        println("자동차 대수는 몇 대인가요?")
        val numberOfCars = readLine()!!.toInt()
        println("시도할 횟수는 몇 회인가요?")
        val count = readLine()!!.toInt()

        return numberOfCars to count
    }
}
