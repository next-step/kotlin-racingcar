package racingcar

data class ResultView(val result: List<Round>) {
    fun title() {
        println("실행 결과")
    }

    private fun roundTitle(round: Int) {
        println("$round 라운드")
    }

    private fun newLine() {
        println()
    }

    fun result() {
        result.mapIndexed { index, it ->
            roundTitle(index + 1)
            it.getResult().forEach {
                println(it)
            }

            newLine()
        }
    }
}