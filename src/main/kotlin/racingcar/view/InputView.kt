package racingcar.view

class InputView {
    fun getNumberOfCar(): String {
        println("자동차 대수는 몇 대인가요?")
        return readln()
    }

    fun getNumberOfTrying(): String {
        println("시도할 횟수는 몇 회인가요?")
        return readln()
    }
}
