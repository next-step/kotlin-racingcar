package _3_racing_car.ui

data class ResultView(val result: Map<String, Int>) {

    fun print() {
        println("실행 결과")
        result.forEach { (name, location) ->
            println("$name : ${MARKED.repeat(location)}")
        }
        println("${getWinners(result).joinToString(", ")}가 최종 우승했습니다.")
    }

    private fun getWinners(result: Map<String, Int>): List<String> {
        val maxLocation = result.maxByOrNull { it.value }?.value

        return result.filter { it.value == maxLocation }.map { it.key }
    }

    companion object {
        const val MARKED = "-"
    }
}
