package racingcar.view

private const val CAR_NAME_SPLITTER = ","

class ConsoleInput : InputView {
    override fun askCountOfCars(): Int {
        return try {
            println("자동차 대수는 몇 대 인가요?")
            readln().toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            askCountOfCars()
        }
    }

    override fun askCountOfTrial(): Int {
        return try {
            println("시도할 횟수는 몇 회인가요?")
            readln().toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            askCountOfCars()
        }
    }

    override fun askCarNames(): List<String> {
        return try {
            println("자동차 이름을 입력해주세요")
            readln().split(CAR_NAME_SPLITTER).map { it.trim() }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            askCarNames()
        }
    }
}
