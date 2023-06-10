package next.step.racing.service

object OutputDevice {
    private const val UNKNOWN_ERR_MSG = "알 수 없는 에러가 발생했습니다."
    private const val RESULT_TITLE = "실행 결과"
    fun showResult(allPositions: List<List<Int>>) {
        println()
        println(RESULT_TITLE)
        for (positions in allPositions) {
            for (position in positions) {
                println("-".repeat(position))
            }
            println()
        }
    }

    fun showError(msg: String?) {
        println(msg ?: UNKNOWN_ERR_MSG)
    }
}
