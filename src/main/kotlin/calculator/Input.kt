package calculator

import java.util.Scanner

class Input {
    private val scan: Scanner = Scanner(System.`in`)

    fun inputString(): String {
        return scan.nextLine()
    }
}
