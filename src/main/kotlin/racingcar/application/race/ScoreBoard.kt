package racingcar.application.race

import racingcar.application.port.output.OutputPort
import java.util.StringJoiner

class ScoreBoard(
    private val outputPort: OutputPort
) {

    fun initRace(names: List<String>) {
        outputPort.output(RESULT_COMMENT)
        outputPort.outputNewLine()
        names.forEach {
            outputPort.output("$it: ")
            outputPort.output(LITERAL_POSITION)
            outputPort.outputNewLine()
        }
        outputPort.outputNewLine()
        Thread.sleep(PER_RACE_ROUND_SECONDS)
    }

    fun nextRound(position: Int, carName: String) {
        outputPort.output("$carName: ")
        IntRange(start = START_POSITION_NUMBER, endInclusive = position).forEach { _ ->
            outputPort.output(LITERAL_POSITION)
        }
        outputPort.outputNewLine()
    }

    fun winnersAnnounce(carNames: List<String>) {
        outputPort.output("우승자 발표")
        outputPort.outputNewLine()
        outputPort.output("두구두구두구----")
        outputPort.outputNewLine()
        Thread.sleep(PER_RACE_ROUND_SECONDS)

        val stringJoiner = StringJoiner(",")
        carNames.map { stringJoiner.add(it) }
        outputPort.output("${stringJoiner}가 최종 우승했습니다 !!!")
    }

    fun term() {
        outputPort.outputNewLine()
        Thread.sleep(PER_RACE_ROUND_SECONDS)
    }

    private companion object {
        private const val RESULT_COMMENT = "처리 결과"
        private const val LITERAL_POSITION = "-"
        private const val PER_RACE_ROUND_SECONDS = 2000L
        private const val START_POSITION_NUMBER = 0
    }
}
