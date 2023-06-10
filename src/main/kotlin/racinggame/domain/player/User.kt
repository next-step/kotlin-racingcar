package racinggame.domain.player

data class User(
    val id: String,
)

fun User.toRacer() = Racer(
    id = id,
)
