package racingcar.view

class ConsoleInput {
    fun readNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readNotBlankLine().split(',')
    }

    fun readRoundsToRace(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readNotBlankLine().toInt()
    }

    private fun readNotBlankLine() = readln().ifBlank { throw IllegalArgumentException("empty string is not allowed") }
}
