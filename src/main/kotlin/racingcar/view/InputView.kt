package racingcar.view

class InputView {
    fun getNumberOfCars(): String {
        println("자동차 대수는 몇 대인가요?")
        return readln()
    }

    fun getNumberOfGames(): String {
        println("시도할 횟수는 몇 회인가요?")
        return readln()
    }
}
