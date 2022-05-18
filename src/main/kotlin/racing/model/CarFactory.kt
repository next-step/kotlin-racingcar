package racing.model

object CarFactory {
    fun makeCars(names: Names): Cars {
        return Cars(names.names.map { Car(it, Position()) })
    }
}
