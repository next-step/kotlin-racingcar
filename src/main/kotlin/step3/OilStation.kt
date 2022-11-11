package step3

object OilStation {
    private val randomRange = (0..9)

    fun getOilRandomly(): Oil {
        return Oil(amount = randomRange.random())
    }
}
