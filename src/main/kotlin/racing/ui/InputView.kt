package racing.ui

object InputView {

    fun getNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException("자동차 대수는 숫자 형식으로 입력해주세요")
    }

    fun getTryCounts(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException("시도할 횟수는 숫자 형식으로 입력해 주세요")
    }
}
