package racing.view

class InputView {

    fun readInRoundSize(): Int {
        println("시도할 횟수는 몇 회인가요?")

        var roundSize = 0
        kotlin.runCatching {
            readln().toInt()
        }.fold(
            onSuccess = { roundSize = it },
            onFailure = { exception ->
                if (exception is NumberFormatException) {
                    println("-- 시도할 횟수를 잘못 입력하셨습니다. 숫자를 입력해주세요 --")
                    readInRoundSize()
                }
            }
        )

        return roundSize
    }
    fun readInCarSize(): Int {
        println("자동차 대수는 몇 대인가요?")

        var carSize = 0
        kotlin.runCatching {
            readln().toInt()
        }.fold(
            onSuccess = { carSize = it },
            onFailure = { exception ->
                if (exception is NumberFormatException) {
                    println("-- 자동차 대수를 잘못 입력하셨습니다. 숫자를 입력해주세요 --")
                    readInCarSize()
                }
            }
        )

        return carSize
    }
}
