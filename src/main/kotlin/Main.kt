import step3.Cars
import step3.Round
import step3.ui.Input
import step3.ui.Output

fun main() {
    val cars = Cars(numberOfCount = Input.getCountOfCar())
    val rond = Round(number = Input.getNumberOfRound())
    Output.printResult(cars = cars, round = rond)
}
