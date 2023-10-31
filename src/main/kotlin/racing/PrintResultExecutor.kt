package racing

object PrintResultExecutor {
    fun execute(carMap: MutableMap<Int, String>) {
        for ((_, value) in carMap) {
            println(value)
        }
    }
}
