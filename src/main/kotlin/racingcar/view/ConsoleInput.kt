package racingcar.view

class ConsoleInput: InputView {
    override fun askCountOfCars(): Int {
        return try {
            println("자동차 대수는 몇 대 인가요?")
            val input = readLine()
            require(input != null) { "잘못된 입력 값 입니다." }
            input.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            askCountOfCars()
        }
    }

    override fun askCountOfTrial(): Int {
        return try {
            println("시도할 횟수는 몇 회인가요?")
            val input = readLine()
            require(input != null) { "잘못된 입력 값 입니다." }
            input.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            askCountOfCars()
        }
    }
}
