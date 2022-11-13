package racing.view

class InputView {
    fun getNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readLine()?.toInt() ?: throw IllegalArgumentException("자동차 대수는 숫자로 입력 해 주세요.")
    }

    fun getNumberOfGames(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()?.toInt() ?: throw IllegalArgumentException("시도할 횟수는 숫자로 입력 해 주세요.")
    }
}
