package racing.domain

class Cars(count: Int) {

    private val list: List<Car>

    init {
        list = List(count) {
            Car()
        }
    }

    fun count() = list.size

    fun list() = list
}
