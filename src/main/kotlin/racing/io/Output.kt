package racing.io

import racing.domain.Position
import racing.domain.Positions
import racing.domain.Result

object Output {
    private const val RESULT_MESSAGE = "실행 결과"

    fun resultMessage(result: Result) {
        println(RESULT_MESSAGE)
        println(ResultMaker.makeWholeResult(result))
    }

    private object ResultMaker {
        private const val MARK: String = "-"
        private const val LINE_BREAK: String = "\n"

        fun makeWholeResult(result: Result): String {
            val sb = StringBuilder()
            val roundPositions: List<Positions> = result.positions
            for (roundPosition: Positions in roundPositions) {
                makeRoundResult(roundPosition, sb)
            }
            return sb.toString()
        }

        private fun makeRoundResult(roundPosition: Positions, sb: StringBuilder) {
            val positions = roundPosition.positions
            for (position: Position in positions) {
                makeCarResult(position.value, sb)
            }
            sb.append(LINE_BREAK)
        }

        private fun makeCarResult(position: Int, sb: StringBuilder) {
            for (i in 0 until position) {
                sb.append(MARK)
            }
            sb.append(LINE_BREAK)
        }
    }
}
