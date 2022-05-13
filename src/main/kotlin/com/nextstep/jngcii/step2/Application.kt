package com.nextstep.jngcii.step2

fun main() {
    val calculator = SimpleCalculator()
    val computer = Computer(calculator)

    var input: String?

    while (true) {
        print("계산 식을 입력하세요 : ")
        input = readLine()
        if (input.isNullOrBlank()) break

        val requests = input.convertToRequests()
        val result = computer.compute(requests)

        println("답은 $result 입니다.")
        println("=======================")
    }
}
