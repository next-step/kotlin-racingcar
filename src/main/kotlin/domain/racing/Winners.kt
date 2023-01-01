package domain.racing

data class Winners(val winners: List<Car>) {
    companion object {
        fun of(cars: List<Car>): Winners {
            val maxPosition = cars.maxOfOrNull { it.getPosition() }
            val winners = cars.filter { it.getPosition() == maxPosition }

            return Winners(winners)
        }
    }
}
