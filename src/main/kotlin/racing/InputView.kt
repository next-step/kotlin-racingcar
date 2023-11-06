package racing

class InputView {
    fun get(prompt: String): Int {
        print(prompt)
        return readln().toPositiveIntOrNull() ?: retryGet(prompt)
    }

    private fun retryGet(prompt: String): Int {
        println("다시 입력해 주세요.")
        return get(prompt)
    }

    private fun String.toPositiveIntOrNull(): Int? {
        return toIntOrNull(radix = 10)?.takeIf { it > 0 }
    }
}
