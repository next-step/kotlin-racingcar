package racing.domain

object CarFactory {
    fun makeCars(names: Names): Cars {
        return Cars(names)
    }
}
