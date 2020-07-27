package com.nextstep.stringcalculator

import com.nextstep.stringcalculator.domain.StringStore
import java.util.Scanner

object StringCalculatorApplication {
    private val sc = Scanner(System.`in`)
    private var runnable = true

    @JvmStatic
    fun main(args: Array<String>) {
        while (runnable) {
            run()
        }
        println("계산기를 종료합니다.")
    }

    private fun run() {
        try {
            val string = userInput()
            if (string == "exit") {
                runnable = false
                return
            }
            val store = StringStore(string)
            println(store.calculate())
        } catch (e: IllegalArgumentException) {
            println(String.format("계산에 실패하였습니다. %s", e.message))
            return
        }
    }

    private fun userInput(): String {
        println("계산할 문자열을 입력해주세요.")
        return sc.nextLine()
    }
}
