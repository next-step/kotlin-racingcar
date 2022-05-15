package racingcar.domain

object CarFixture {
    val initCars = listOf(
        Car(position = 0, name = "car1"),
        Car(position = 0, name = "car2"),
        Car(position = 0, name = "car3"),
    )
    val racingCarOneWinner = listOf(
        Car(position = 0, name = "car1"),
        Car(position = 1, name = "car2"),
        Car(position = 2, name = "car3"),
    )
    val racingCarAllWinner = listOf(
        Car(position = 1, name = "car1"),
        Car(position = 1, name = "car2"),
        Car(position = 1, name = "car3"),
    )
    val car = Car(position = 0, name = "myCar")
}
