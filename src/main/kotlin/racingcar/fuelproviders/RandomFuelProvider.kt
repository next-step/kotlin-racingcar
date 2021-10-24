package racingcar.fuelproviders

class RandomFuelProvider(private val minFuel: Int, private val maxFuel: Int) : FuelProvider {
    override fun getFuel(): Int {
        return (minFuel..maxFuel).random()
    }
}
