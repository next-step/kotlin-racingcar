package racing

val goEngine = object : Engine {
    override fun canMove() = true
}

val stopEngine = object : Engine {
    override fun canMove() = false
}

fun Car(name: CarName, position: Int): Car {
    return Car(goEngine, name).apply {
        repeat(position) { go() }
    }
}

fun Car(name: String, position: Int) = Car(CarName(name), position)
