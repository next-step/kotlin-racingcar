package race.view

import race.view.Message.RESULT_TITLE

class Output {
    fun printResult(records: HashMap<Int, MutableList<Boolean>>) {
        println(RESULT_TITLE)
        val raceCount = records[records.keys.first()]!!.size
        for (currentRace in 0 until raceCount) {
            println("${currentRace + 1}번째 레이스")
            printCarMovement(records, currentRace)
        }
    }

    private fun printCarMovement(
        records: HashMap<Int, MutableList<Boolean>>,
        currentRace: Int
    ) {
        records.forEach { record ->
            val isMovements = record.value.slice(0 until currentRace + 1)
            val movementCount = isMovements.count { it }
            println("-".repeat(movementCount))
        }
    }
}
