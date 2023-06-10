package racingcar.view

class InputView {
    private fun getInput(): Int {
        return readln().toInt()
    }

    fun getCarNumber(): Int {
        println("자동차 대수는 몇 대인가요?")
        return getInput()
    }

    fun getRoundNumber(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return getInput()
    }
}
