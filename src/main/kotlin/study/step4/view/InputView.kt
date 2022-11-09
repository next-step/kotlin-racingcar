package study.step4.view

object InputView {
    fun inputRacingCarInfo(): Pair<String, Int> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).?")
        val racingCarNames: String? = readLine()
        InputValid.racingCarNameValid(racingCarNames)

        println("시도할 횟수는 몇 회인가요?")
        val repeatTime: String? = readLine()
        InputValid.repeatTimeValid(repeatTime)

        requireNotNull(racingCarNames)
        requireNotNull(repeatTime)
        return racingCarNames to repeatTime.toInt()
    }
}
