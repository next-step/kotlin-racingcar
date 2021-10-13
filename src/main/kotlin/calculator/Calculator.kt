package calculator

class Calculator(private val input: String) {
    fun calculate(): Int {
        val list = input.split(" ")
        return list.subList(1, list.size)
            .chunked(2)
            .map { Pair(IntArithmetics.from(it[0]), it[1].toInt()) }
            .fold(list[0].toInt()) { acc, curr -> curr.first.apply(acc, curr.second) }
        /*
        FIXME: Pair 의 first 와 second 로 하다보니깐 가독성이 떨어진다.
        first 를 number 로 명명하고, second 를 arithmetic 으로 명명해서 가독성을 더 좋게 할 수는 없을까?
         */
    }
}
