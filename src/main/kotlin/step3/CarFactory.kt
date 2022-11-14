package step3

object CarFactory {
    fun createMany(amount: Int): List<Car> {
        return (1..amount).map { index ->
            Car(id = index)
        }
    }
}
