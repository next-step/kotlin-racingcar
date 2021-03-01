package racingcar

import java.io.InputStream
import java.util.Scanner

interface UserInput<T> {
    fun answer(): T

    class Int(private val question: String, inputStream: InputStream = System.`in`) : UserInput<kotlin.Int> {
        private val scanner = Scanner(inputStream)

        override fun answer(): kotlin.Int {
            println(question)
            return scanner.nextInt()
        }
    }
}
