package racinggame.domain.field

data class MoveDistance(
    val startPosition: Int,
    val currentPosition: Int,
) {
    val distance = currentPosition - startPosition
}
