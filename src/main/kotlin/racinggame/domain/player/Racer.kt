package racinggame.domain.player

data class Racer(
    val id: String,
    val ordinal: Int,
)

fun Racer.toUser(): User {
    return User(
        id = id,
    )
}
