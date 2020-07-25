package com.nextstep

import com.nextstep.domain.StringStore
import java.util.Scanner

object StringCalculatorApplication {
    private val sc = Scanner(System.`in`)
    @JvmStatic
    fun main(args: Array<String>) {
        while (true) {
            run()
        }
    }

    private fun run() {
        try {
            val store = userInput()
            println(store.calculate())
        } catch (e: IllegalArgumentException) {
            println(String.format("계산에 실패하였습니다. %s", e.message))
            return
        }
    }

    private fun userInput(): StringStore {
        println("계산할 문자열을 입력해주세요.")
        val string = sc.nextLine()
        return StringStore(string)
    }
}
