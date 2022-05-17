package racing.ui

object RacingInputView {

    private const val DELIMITER = ","
    private val regex = Regex("[\\t\\s]")
    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNamesStr = readln()
        return parseCarNamesStr(carNamesStr)
    }

    fun parseCarNamesStr(carNamesStr: String): List<String> {
        val result = regex.replace(carNamesStr, "")
            .split(DELIMITER)

        check( result.all { name -> name.length <= 5} ) {
            "자동차 이름은 5자를 초과할 수 없습니다."
        }

        return result
    }

    fun getNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readln().toInt()
    }

    fun getTries(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}