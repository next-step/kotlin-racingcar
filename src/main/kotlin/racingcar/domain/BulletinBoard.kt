package racingcar.domain

class BulletinBoard(val scores: Map<Lap, Records> = mapOf(), val winners: Names = Names.of(listOf())) {

    fun record(participants: RacingCars, lap: Lap): BulletinBoard {
        val temp = scores.toMutableMap()
        temp[lap] = Records.of(participants)
        return BulletinBoard(temp, calculateWinner(participants))
    }

    private fun calculateWinner(participants: RacingCars): Names {
        val max = participants.values.maxOf { it.position.value }
        return Names.of(participants.values.filter { it.position.value == max }.map { it.name.value })
    }

    companion object {
        val EMPTY_BULLETIN_BOARD = BulletinBoard(scores = emptyMap(), winners = Names.of(listOf()))
    }
}
