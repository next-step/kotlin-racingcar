package racing

val goEngine = object : Engine {
    override fun canMove() = true
}

val stopEngine = object : Engine {
    override fun canMove() = false
}
