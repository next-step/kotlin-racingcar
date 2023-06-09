import calculator.Calculator
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val calculator = Calculator(scanner.nextLine())
    println("result = " + calculator.calculate())
}
