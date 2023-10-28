package step3.carRacing

internal class DispatchHandlerTest {

    fun subscribeAndDispatch() {
        val dispatchHandler = DispatchHandler<String, Unit>();
        dispatchHandler.subscribe("TEST", {})


    }
}
