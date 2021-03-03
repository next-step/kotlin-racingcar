package view.console

import racing.ui.RacingCarDto
import racing.ui.RacingCarDtos

class ConsoleOutput {
    fun printExpressionInputMessage() = println("계산식을 입력해주세요.")

    fun printCalculatorResultMessage(result: Double) = println("결과는 $result 입니다.")

    fun printCarCountInputMessage() = println("자동차 대수는 몇 대인가요?")

    fun printCarNameInputMessage() = println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분)")

    fun printTryCountInputMessage() = println("시도할 횟수는 몇 회인가요?")

    fun printRacingGameResultMessage() = println("실행 결과")

    fun printRacingGameRecord(dtos: List<RacingCarDtos>) = dtos.forEach { printOneTryRecord(it) }

    private fun printOneTryRecord(it: RacingCarDtos) =
        it.racingCarDtos.forEach { printEachCarRecord(it) }
            .apply { println() }

    private fun printEachCarRecord(dto: RacingCarDto) =
        print("${dto.name} : ")
            .apply { repeat(dto.position) { print("-") } }
            .apply { println() }
}
