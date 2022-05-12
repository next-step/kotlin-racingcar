package racing

object CarRacingInputView {
    fun input(): CarRacingInputData {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readLine()!!.toInt()
        println("시도할 횟수는 몇 회인가요?")
        val moveCount = readLine()!!.toInt()

        return CarRacingInputData(carCount = carCount, moveCount = moveCount)
    }
}
