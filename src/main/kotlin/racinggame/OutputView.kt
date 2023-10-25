package racinggame

object OutputView {

    fun output(result: List<List<String>>) {
        println("실행 결과")
        result.forEach {
            it.forEach {
                println(it)
            }
            println()
        }
    }
}