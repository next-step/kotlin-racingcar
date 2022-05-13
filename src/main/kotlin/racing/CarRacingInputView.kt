package racing

object CarRacingInputView {
    fun input(): CarRacingInputData {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames: List<String> = readLine()!!.split(",")
        println("시도할 횟수는 몇 회인가요?")
        val moveCount = readLine()!!.toInt()

        return CarRacingInputData(carNames = carNames, moveCount = moveCount)
    }
}
