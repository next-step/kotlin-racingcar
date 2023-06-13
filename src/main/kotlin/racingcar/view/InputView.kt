package racingcar.view

private const val DELIMITER = ","

val inputCarNames: List<String>
    get() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표($DELIMITER)를 기준으로 구분).")
        val readLine: String = readln()
        require(readLine.isNotBlank()) { "racing car is required" }
        return readLine.split(DELIMITER)
    }

val inputLabs: Int
    get() {
        println("시도할 회수는 몇 회인가요?")
        val readLine: String = readln()
        require(readLine.isNotBlank()) { "labs is required" }
        return readLine.toInt()
    }
