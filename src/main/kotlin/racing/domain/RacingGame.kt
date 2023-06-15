package racing.domain

class RacingGame(
    private val cars: Cars,
    private val tryCount: Int,
) {
    fun race(movePolicy: MovePolicy): List<Cars> {
        return List(tryCount) {
            cars.play(movePolicy)
            mutate()
        }
    }

    private fun mutate() = Cars(
        cars.map {
            Car(it.name, it.position)
        }
    )
}
