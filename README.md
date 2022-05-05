# kotlin-racingcar

#기능 요구 사항

사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

#TODO LIST
~~덧셈~~  
~~뺄셈~~  
~~곱셈~~  
~~나눗셈~~  
~~입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw~~  
~~사칙연산 기호가 아닌 경우 IllegalArgumentException throw~~  
~~사칙 연산을 모두 포함하는 기능 구현~~  
~~CsvSource 사용하기~~  
~~테스트 이름 상세하게 표현하기~~  
~~assertThrows / assertThatExceptionOfType 차이알아보고 수정하기~~   
~~validOperator 함수분리~~
~~StringCalculator input하나로 받기~~    
~~StringCalculator 재사용하게 변경~~  
~~StringCalculator를 사용한 콘솔프로그램 만들기~~  
~~Operation 계산로직 Operator가 담당하게 변경~~  
~~린트 체크~~  

메인으로 파일들 이동  
readLine, readln 차이 알아보고 필요하면 적용  
~~IllegalArgumentException kotlin에 선언된걸로 사용~~  
계산로직 operator로 이동하기  
에러상수 접근한정자제한 및 위치수정  
오퍼레이터 테스트코드 작성  