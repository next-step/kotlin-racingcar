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
    fun readInCarName(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")

        var carNames: List<String> = emptyList()
        kotlin.runCatching {
            readln().split(",")
        }.fold(
            onSuccess = { carNames = it },
            onFailure = { exception ->
                throw Exception(exception)
            }
        )

        return carNames
    }
}
