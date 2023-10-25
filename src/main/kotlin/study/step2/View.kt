package study.step2

import java.util.Scanner

class View {

    companion object {
        fun printInputView(): String {
            println("수식을 입력하세요.")
            val scanner = Scanner(System.`in`)
            val word = scanner.nextLine()
            inputValidation(word)
            scanner.close()

            return word.replace(" ","")
        }

        fun inputValidation(input: String?) {
            if (input.isNullOrBlank()) {
                throw IllegalArgumentException("입력된 수식이 올바르지 않습니다")
            }
        }

        fun printResultView(score: Double) {
            println("------------------------------------")
            println("결과 : " + score)
            println("------------------------------------")
        }
    }
}
