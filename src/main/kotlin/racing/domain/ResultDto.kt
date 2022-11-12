package racing.domain

class ResultDto(val result: String) {
    companion object {
        private const val MARK: String = "-"
        private const val LINE_BREAK: String = "\n"

        fun from(result: Result): ResultDto {
            val sb = StringBuilder()
            val roundPositions: List<Positions> = result.positions
            for (roundPosition: Positions in roundPositions) {
                makeRoundResult(roundPosition, sb)
            }
            return ResultDto(sb.toString())
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
