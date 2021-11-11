package racingcar.ui

import racingcar.dto.ScoreboardConsoleDto

object SimpleRacingCarView : RacingCarView {
    override fun carNames() = requireInput {
        println("경주할 자동차 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분")
    }

    override fun lapCount() = requireInput {
        println("시도할 횟수는 몇 회인가요?")
    }

    override fun showResult(dto: ScoreboardConsoleDto) {
        println("실행 결과")
        println(dto.result)
        println("${System.lineSeparator()}${dto.winners}가 최종 우승했습니다.")
    }
}
