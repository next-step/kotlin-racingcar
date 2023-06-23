package racingcar.view

object InputView {
    fun receiveCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

        return receive().split(",")
    }

    fun receiveTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")

        var tryCount: Int?

        do {
            tryCount = receive().toIntOrNull()
        } while (tryCount == null)

        return tryCount
    }

    private fun receive(): String {
        var value: String?

        do {
            value = readlnOrNull()
        } while (value.isNullOrBlank())

        return value
    }
}
