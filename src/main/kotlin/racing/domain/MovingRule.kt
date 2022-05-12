package racing.domain

interface MovingRule {
    fun goForward(car: List<Car>): List<Car>
}
