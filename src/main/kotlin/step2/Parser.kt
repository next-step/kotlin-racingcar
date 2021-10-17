package step2

import java.util.LinkedList
import java.util.Queue

class Parser(private val delimiter: String) {

    fun parse(input: String?): Queue<String> {
        requireNotNull(input) {
            "입력값이 null이면 안됩니다."
        }
        if (input.isBlank()) {
            throw IllegalArgumentException("입력값이 빈 공백 문자이면 안됩니다.")
        }

        val dataList = input.split(delimiter)
        val queue: Queue<String> = LinkedList()

        for (data in dataList) {
            if (isDigit(data)) {
                queue.add(data)
                continue
            }
            if (Operator.validate(data)) {
                queue.add(data)
            }
        }

        return queue
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
