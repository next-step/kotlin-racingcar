package racingcar

object InputView {
    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = readLine()!!.split(",")

        carNames.forEach {
            if (it.length > 5) {
                throw IllegalArgumentException("자동차의 이름은 최대 5자를 초과할 수 없습니다.")
            }
        }

        return carNames
    }

    fun getRoundCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()!!.toInt()
    }
}
