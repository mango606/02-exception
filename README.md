# 👩‍💻Spring Boot Web

## 01. Response Entity
|String|일반 Text Type 응답|
|---|---|
|Object|자동으로 Json 변환되어 응답|
|ResponseEntity|Body의 내용을 Object로 설정, 상황에 따라서 HttpStatus Code 설정|
|@ResponseBody|RestController가 아닌 곳(Controller)에서 Json 응답을 내릴 때|

## 02. Spring Boot의 다양한 기능
- ObjectMapper 직렬화, 역직렬화

## 03. Spring Boot에서의 예외처리 - 1
- ControllerAdvice를 통해 예외를 잡는 방법
- REST API가 사용하는 곳에서 예외가 일어나는 것을 감지함.
- ExceptionHandler 구현