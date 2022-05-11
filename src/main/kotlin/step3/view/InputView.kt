package step3.view

import step3.CarRaceConst

class InputView {

    fun readInRoundSize() {
        println("시도할 횟수는 몇 회인가요?")

        kotlin.runCatching {
            readln().toInt()
        }.fold(
            onSuccess = { CarRaceConst.roundSize = it },
            onFailure = { exception ->
                if (exception is NumberFormatException) {
                    println("-- 시도할 횟수를 잘못 입력하셨습니다. 숫자를 입력해주세요 --")
                    readInRoundSize()
                }
            }
        )
    }
    fun readInCarSize() {
        println("자동차 대수는 몇 대인가요?")

        kotlin.runCatching {
            readln().toInt()
        }.fold(
            onSuccess = { CarRaceConst.carSize = it },
            onFailure = { exception ->
                if (exception is NumberFormatException) {
                    println("-- 자동차 대수를 잘못 입력하셨습니다. 숫자를 입력해주세요 --")
                    readInCarSize()
                }
            }
        )
    }
}
