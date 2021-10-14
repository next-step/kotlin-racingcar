package step2

import java.io.BufferedReader
import java.io.InputStreamReader

class Calculator {
    private lateinit var data: String

    companion object {
        private val br = BufferedReader(InputStreamReader(System.`in`))
    }

    fun read() {
        data = br.readLine()
    }
}
