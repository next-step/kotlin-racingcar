package step3

class ResultView {
    fun printRacingResult(records: Map<Car, List<String>>) {
        records.forEach { record ->
            println(record.value.joinToString(JOIN_CHARACTER_FOR_RECORD))
        }
    }

    fun printNextRacing() {
        println()
    }

    companion object {
        private const val JOIN_CHARACTER_FOR_RECORD = ""
    }
}
