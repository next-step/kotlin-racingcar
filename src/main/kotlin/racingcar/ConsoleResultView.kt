package racingcar

object ConsoleResultView : ResultProvider {
    override fun printItems(items: List<Displayable>) {
        items.forEach { println(it.display()) }
        println()
    }
}
