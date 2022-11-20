package racing.domain

class CarFactory {

    companion object {
        fun create(count: Int): Cars {
            return Cars(count)
        }
    }
}
