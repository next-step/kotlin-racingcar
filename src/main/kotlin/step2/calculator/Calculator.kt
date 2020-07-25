package step2.calculator

interface Calculator {
    /**
     * Node 리스트를 받으면 정수로 결과를 반환 한다.
     */
    fun calculate(input: List<Node>): Int
}
