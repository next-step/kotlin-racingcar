package racing

class RacingGame(
    private val cars: Cars,
) {
    fun race(tryCount: Int, movePolicy: MovePolicy): List<Cars> {
        return List(tryCount) {
            cars.play(movePolicy)
            cars
        }
    }
}
