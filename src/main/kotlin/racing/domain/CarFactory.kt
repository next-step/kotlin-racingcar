package racing.domain

class CarFactory {

    companion object {
        fun create(names: String): Cars {
            return Cars(names)
        }
    }
}
