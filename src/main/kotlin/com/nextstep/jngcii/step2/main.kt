package com.nextstep.jngcii.step2

import java.util.Scanner

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)

    var input: String

    while (true) {
        print("계산 식을 입력하세요 : ")
        input = sc.nextLine()
        if (input.isEmpty()) break

        val requests = input.convertToRequests()

        // todo : calculate

        println("=======================")
    }
}
