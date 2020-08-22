package racingCar.domain

object Winner {
    fun getRacingWinner(participants: List<Car>): String {
        val maxDistance = participants.map { it.distance }.max()
        return participants.filter { it.distance == maxDistance && it.distance > 0 }.joinToString { it.name }
    }
}
