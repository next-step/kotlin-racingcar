package car.racing

class ResultView(private val console: (String) -> Unit) {

    fun showRecords(gameRecords: GameRecords) {
        showRecords(gameRecords.records)
    }

    private fun showRecords(records: List<List<Int>>) {
        console("실행 결과:\n")
        records.forEach(::showRecord)
    }

    private fun showRecord(record: List<Int>) {
        record.forEach { move ->
            repeat(move) {
                console(DISPLAY_MOVEMENT)
            }
            showEmptyLine()
        }
        showEmptyLine()
    }

    private fun showEmptyLine() = console("\n")

    companion object {
        private const val DISPLAY_MOVEMENT = "-"
    }
}
