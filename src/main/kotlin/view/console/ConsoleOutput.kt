package view.console

import racing.ui.RacingCarDto
import racing.ui.RacingCarDtos

class ConsoleOutput {
    fun printExpressionInputMessage() = println("계산식을 입력해주세요.")

    fun printCalculatorResultMessage(result: Double) = println("결과는 $result 입니다.")

    fun printCarCountInputMessage() = println("자동차 대수는 몇 대인가요?")

    fun printTryCountInputMessage() = println("시도할 횟수는 몇 회인가요?")

    fun printRacingGameResultMessage() = println("실행 결과")

    fun printRacingGameRecord(dtos: List<RacingCarDtos>) =
        dtos.forEach { it -> it.dtos.forEach { printCarRecord(it); println() }; println() }

    private fun printCarRecord(dto: RacingCarDto) = repeat(dto.position) { print("-") }
}
