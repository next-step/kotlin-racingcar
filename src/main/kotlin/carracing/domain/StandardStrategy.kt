package carracing.domain

class StandardStrategy(
    var number: Int
) : MoveStrategy {

    override fun isMovable(): Boolean {
        if (number >= 4) {
            return true
        }
        return false
    }
}
