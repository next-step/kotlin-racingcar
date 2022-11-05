package racingcar.view

interface ResultView {
    fun printResultTitle(title: String) = println(title)
    fun printResult(any: List<Any>) = repeat(any.size) { println(any) }
}
