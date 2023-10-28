package step3.carRacing

sealed class Payload {
    data class FinishInput(val carCount: Int, val tryCount: Int) : Payload()
    data class FinishRace(val cars: List<Car>, val round: Int) : Payload()
}

enum class Action {
    FINISH_INPUT,
    FINISH_RACE
}

class DispatchHandler<U, T> {
    private val actions = mutableMapOf<U, (payload: T) -> Unit>()

    fun subscribe(action: U, handler: (T) -> Unit) {
        actions[action] = handler
    }

    fun dispatch(action: U, payload: T) {
        actions[action]?.let { it(payload) }
    }
}
