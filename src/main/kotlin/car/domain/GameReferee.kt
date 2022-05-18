package car.domain

object GameReferee {

    fun getWinners(records: List<Record>): List<Record> {
        val farthestMoves = records.getFarthestMoves()
        return if (farthestMoves == 0) {
            emptyList()
        } else {
            records.filter { it.moves == farthestMoves }
        }
    }

    private fun List<Record>.getFarthestMoves(): Int {
        return maxOfOrNull { it.moves } ?: 0
    }
}
