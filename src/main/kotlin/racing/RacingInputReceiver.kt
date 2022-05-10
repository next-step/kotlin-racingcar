package racing

class RacingInputReceiver {

    @Throws(IllegalArgumentException::class)
    fun receive(): UserInput {
        println("자동차 대수는 몇 대인가요?")
        val carNumber = requireNotNull(readLine()?.toInt())

        println("시도할 횟수는 몇 회인가요?")
        val moveCount = requireNotNull(readLine()?.toInt())

        return UserInput(carNumber, moveCount)
    }
}
