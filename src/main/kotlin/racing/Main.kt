package racing

fun main() {
    val cars = CarsController.createCars()
    val played = CarsController.play(cars)
    CarsController.announceWinner(played)
}
