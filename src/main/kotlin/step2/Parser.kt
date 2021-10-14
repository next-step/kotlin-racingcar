package step2

import java.util.LinkedList
import java.util.Queue

class Parser {

    fun parse(input: String): Queue<String> {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자는 안됩니다.")
        }

        val dataList = input.split(" ")
        val queue: Queue<String> = LinkedList()

        for (data in dataList) {
            if (isDigit(data)) {
                queue.add(data)
                continue
            }
            if (isOperand(data)) {
                queue.add(data)
            }
        }

        return queue
    }

    private fun isOperand(data: String): Boolean {
        for (character in data.toCharArray()) {
            if (character != '+' && character != '-' && character != '*' && character != '/') {
                throw IllegalArgumentException("입력값이 옳지 않습니다. $character")
            }
        }
        return true
    }

    private fun isDigit(data: String): Boolean {
        for (character in data.toCharArray()) {
            if (!character.isDigit() && character != '.') {
                return false
            }
        }
        return true
    }
}
