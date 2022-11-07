package game.racingcar.view

object InputView {

    fun getInputFromConsole(): Pair<List<String>, Int> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = readLine()?.split(",") ?: throw IllegalArgumentException("자동차 대수는 0 이상의 숫자로 입력해야 합니다.")
        println("시도할 횟수는 몇 회인가요?")
        val numberOfTrials = readLine()?.toInt() ?: throw IllegalArgumentException("시도할 횟수는 0 이상의 숫자로 입력해야 합니다.")
        return Pair(carNames, numberOfTrials)
    }
}
