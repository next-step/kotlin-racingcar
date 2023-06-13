package step3.view

/**
 * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 */
object InputView {

    fun inputNumOfCar(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readNumber()
    }

    fun inputNumOfGame(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readNumber()
    }

    private fun readNumber(): Int {
        return readLine()?.toIntOrNull() ?: 0
    }
}