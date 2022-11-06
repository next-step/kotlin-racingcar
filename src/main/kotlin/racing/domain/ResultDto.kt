package racing.domain

class ResultDto(val result: String) {
    companion object {
        private const val MARK: String = "-"
        private const val LINE_BREAK: String = "\n"

        fun from(result: Result): ResultDto {
            val sb = StringBuilder()
            val roundResults: List<Cars> = result.roundResults
            for (roundResult: Cars in roundResults) {
                makeRoundResult(roundResult, sb)
            }
            return ResultDto(sb.toString())
        }

        private fun makeRoundResult(roundResult: Cars, sb: StringBuilder) {
            val cars = roundResult.cars
            for (car: Car in cars) {
                makeCarResult(car.position, sb)
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
