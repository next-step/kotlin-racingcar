package racingcar.view

class InputView {

    companion object {
        fun inputCountOfCars(): Int {
            println("자동차의 대수는 몇 대인가요?")

            try {
                return readLine()!!.toInt()
            } catch (e: Exception) {
                throw IllegalArgumentException("자동차의 대수를 올바르게 입력하세요.")
            }
        }

        fun inputCountOfTry(): Int {
            println("시도할 횟수는 몇 회인가요?")

            try {
                return readLine()!!.toInt()
            } catch (e: Exception) {
                throw IllegalArgumentException("시도할 횟수를 올바르게 입력하세요.")
            }
        }
    }
}
