package racingcar.view

object InputView {
    fun receiveRequest(): Pair<List<String>, Int> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = readlnOrNull()?.split(",") ?: throw IllegalArgumentException("자동차 이름이 올바르지 않습니다.")

        println("시도할 횟수는 몇 회인가요?")
        val numberOfTries = readln().toIntOrNull() ?: throw IllegalArgumentException("시도할 회수가 올바르지 않습니다.")

        return Pair(carNames, numberOfTries)
    }
}
