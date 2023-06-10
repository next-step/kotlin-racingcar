package racinggame.domain.player

data class User(
    val id: String,
)

fun User.toRacer(
    ordinal: Int,
) = Racer(
    id = id,
    ordinal = ordinal,
)
