package racing.io

import racing.domain.ResultDto

object Output {
    private const val RESULT_MESSAGE = "실행 결과"

    fun resultMessage(resultDto: ResultDto) {
        println(RESULT_MESSAGE)
    }
}
