package car.racing

class ResultView(private val console: (String) -> Unit) {

    fun showRecords(gameRecords: GameRecords) {
        if (gameRecords.isRecorded()) {
            showRecords(gameRecords.records)
            showWinners(gameRecords.winners)
        } else {
            showNoRecords()
        }
    }

    private fun showRecords(records: List<List<Record>>) {
        console("실행 결과:\n")
        records.forEach(::showRecord)
    }

    private fun showRecord(records: List<Record>) {
        records.forEach(::showNameAndMoves)
        showEmptyLine()
    }

    private fun showNameAndMoves(record: Record) {
        console("${record.driverName} : ")
        repeat(record.moves) {
            console(DISPLAY_MOVEMENT)
        }
        showEmptyLine()
    }

    private fun showWinners(winners: List<Record>) {
        console("${winners.joinToString { it.driverName }}가 최종 우승했습니다.")
    }

    private fun showNoRecords() {
        console("유효한 경기 기록이 없습니다.")
    }

    private fun showEmptyLine() = console("\n")

    companion object {
        private const val DISPLAY_MOVEMENT = "-"
    }
}
