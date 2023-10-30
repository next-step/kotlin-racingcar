package carracing.dto

data class RacingRound(
    val round: Int,
    val cars: MutableList<Car> = mutableListOf(),
    val result: MutableList<Car> = mutableListOf()) {

    fun setResult(beforeRound: RacingRound) {
        this.result.forEachIndexed { index, car ->
            car.position += beforeRound.result[index].position
        }
    }
    companion object {
        fun of(round: Int, carCount: Int): RacingRound {
            return RacingRound(round, MutableList(carCount) { Car() })
        }
    }
}