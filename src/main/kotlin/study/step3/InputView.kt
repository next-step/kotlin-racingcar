package study.step3

class InputView {

    fun requestCarCount(): Int =
        request("자동차 대수는 몇 대인가요?").getOrElse {
            printMessage("숫자로 다시 입력하세요.")
            requestCarCount()
        }

    fun requestTryCount(): Int =
        request("시도할 횟수는 몇 회인가요?").getOrElse {
            printMessage("숫자로 다시 입력하세요.")
            requestTryCount()
        }

    private fun request(message: String): Result<Int> {
        printMessage(message)
        return kotlin.runCatching { readln().toInt() }
    }

    private fun printMessage(message: String) {
        println(message)
    }
}
