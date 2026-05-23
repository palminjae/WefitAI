package com.dms.wefitai.exception;

import com.dms.wefitai.dto.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ✅ 아래 메서드를 새로 추가하세요.
    @ExceptionHandler(DuplicateMemberException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateMember(DuplicateMemberException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        // "아이디 중복"은 비즈니스 로직 충돌이므로 409 Conflict 상태가 적절합니다.
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    // DB 제약 조건 위반 시 (예: userId가 unique인데 중복될 때 DB 레벨에서 막힘)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        ErrorResponse errorResponse = new ErrorResponse("이미 사용 중인 아이디입니다.");
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    // 위에서 처리하지 못한 모든 예외를 처리하는 안전망
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ex.printStackTrace();
        ErrorResponse errorResponse = new ErrorResponse("요청 처리 중 서버에 오류가 발생했습니다.");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}