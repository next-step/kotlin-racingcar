package racing.domain

class Routes {

    private val list = mutableListOf<Route>()

    fun add() {
        list.add(Route())
    }

    fun stream() = list.stream()
    fun size() = list.size
}
