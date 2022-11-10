public class javatest {

    int carcurator(String fomula) {
        if(fomula == null || fomula.equals("")){
            throw new IllegalArgumentException();
        }

        String[] arr_fomula = fomula.split(" ");


        int result = 0;

        for (int i = 0; i < arr_fomula.length; i += 2) {
            switch (arr_fomula[i + 1]) {
                case "+":
                    sum(result, Integer.parseInt(arr_fomula[i]));
                    break;
                case "-":
                    minuss(result, Integer.parseInt(arr_fomula[i]));
                    break;
                case "*":
                    multiply(result, Integer.parseInt(arr_fomula[i]));
                    break;
                case "/":
                    divide(result, Integer.parseInt(arr_fomula[i]));
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return result;
    }

    int sum(int operando1, int operando2) {
        return operando1 + operando2;
    }

    int minuss(int operando1, int operando2) {
        return operando1 - operando2;
    }

    int multiply(int operando1, int operando2) {
        return operando1 * operando2;
    }

    int divide(int operando1, int operando2) {
        return operando1 / operando2;
    }

}
