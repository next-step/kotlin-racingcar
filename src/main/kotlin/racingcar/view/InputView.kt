package racingcar.view

class InputView {
    fun numberOfCar(): Int {
        println("자동차 대수는 몇 대 인가요?")
        return readln().toInt()
    }

    fun numberOfAttempts(): Int {
        println("시도할 회수는 몇 회 인가요?")
        return readln().toInt()
    }
}
