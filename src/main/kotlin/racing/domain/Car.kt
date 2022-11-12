package racing.domain

data class Car(val name: String) {

    private val routes = Routes()
    fun move(num: Int) {
        when (num) {
            in 4..9 -> routes.add()
        }
    }

    fun routes() = routes
}
