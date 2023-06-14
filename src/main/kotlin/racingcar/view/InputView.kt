package racingcar.view

object InputView {
    fun receiveCarsSize(): Int {
        println("자동차 대수는 몇 대인가요?")

        return receive()
    }

    fun receiveTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")

        return receive()
    }

    private fun receive(): Int {
        var value: Int?

        do {
            val input = readlnOrNull()
            value = input?.toIntOrNull()
        } while (value == null || value < 1)

        return value
    }
}
