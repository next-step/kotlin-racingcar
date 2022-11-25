package racing.domain

class CarFactory {

    companion object {
        fun create(names: Array<String>): Cars {
            return Cars(names)
        }
    }
}
