package carracing.game.domain.data

data class Race(
    var round: Int = 0,
    val cars: List<Car>,
)
