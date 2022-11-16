package racingcar.view

object InputView {
    const val CAR_NAME_DELIMITER = ","

    fun readCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readLine()!!.toInt()
    }

    fun readCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readLine()!!.toString().split(CAR_NAME_DELIMITER)
    }

    fun readTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()!!.toInt()
    }
}
