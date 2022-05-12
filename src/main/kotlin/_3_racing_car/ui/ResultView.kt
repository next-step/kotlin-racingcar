package _3_racing_car.ui

data class ResultView(val result: List<Int>) {
    fun print() {
        println("실행 결과")
        result.forEach {
            repeat(it) {
                print(marked())
            }
            println()
        }
    }

    private fun marked() = "-"
}
