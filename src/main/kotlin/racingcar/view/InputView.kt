package racingcar.view

val inputCarsCount: Int
    get() {
        println("자동차 대수는 몇 대인가요?")
        val readLine: String = readln()
        require(readLine.isNotBlank()) { "racing car count is required" }
        return readLine.toInt()
    }

val inputLabs: Int
    get() {
        println("시도할 회수는 몇 회인가요?")
        val readLine: String = readln()
        require(readLine.isNotBlank()) { "labs is required" }
        return readLine.toInt()
    }
