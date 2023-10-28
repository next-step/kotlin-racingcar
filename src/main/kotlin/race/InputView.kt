package race

class InputView {
    fun printAndRead(): Pair<Int, Int> {
        println("자동차 대수는 몇 대인가요?")
        val cars: Int = readln().toInt()

        println("시도할 횟수는 몇 회인가요?")
        val moves: Int = readln().toInt()

        return Pair(cars, moves)
    }
}
