package racingcar.ui

import racingcar.dto.ScoreboardConsoleDto

object SimpleRacingCarView : RacingCarView {
    override fun carCount() = requireInput {
        println("자동차 대수는 몇 대인가요?")
    }

    override fun lapCount() = requireInput {
        println("시도할 횟수는 몇 회인가요?")
    }

    override fun showResult(dto: ScoreboardConsoleDto) {
        println("실행 결과")
        println(dto.result)
    }
}
