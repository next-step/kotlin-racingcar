package step3.racing.domain

class Round(racers: List<Car>) {
    val cars = racers.map { Car(it.name, it.distance) }
}
