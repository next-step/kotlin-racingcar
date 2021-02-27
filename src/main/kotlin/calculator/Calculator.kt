package calculator

import java.lang.IllegalArgumentException

class Calculator(private val expression : String?) {
    fun calc(): Int {
        require(!expression.isNullOrBlank());

        val split = expression.split(" ").iterator();

        var result = Integer.parseInt(split.next());

        while(split.hasNext()) {
            var operation = split.next();
            var targetNumber = Integer.parseInt(split.next());

            result = Operation.operationOf(operation)
                .calc(result, targetNumber);
        }

        return result;
    }
}