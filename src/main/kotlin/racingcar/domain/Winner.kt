package racingcar.domain

class Winner(private val carRacing: CarRacing) {
    fun names(): List<Name> {
        val result = carRacing.race()
        val records = result.finalRecords()
        val winnerPosition = records.maxOf { it.position.value }

        return records.filter { it.position.value == winnerPosition }
            .map { it.name }
    }
}
