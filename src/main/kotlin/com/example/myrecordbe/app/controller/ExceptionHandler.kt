package com.example.myrecordbe.app.controller

import com.example.myrecordbe.domain.exception.NotFoundException
import org.apache.commons.logging.LogFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.lang.Nullable
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception

/**
 * 内部例外ハンドラ
 */
@RestControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {
    companion object {
        private val log = LogFactory.getLog(ResponseEntityExceptionHandler::class.java)
    }

    override fun handleExceptionInternal(
        ex: Exception,
        @Nullable body: Any?,
        headers: HttpHeaders,
        statusCode: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        log.error(ex.message, ex)
        // エラー発生時は空のボディを返す
        return super.handleExceptionInternal(ex, null, headers, statusCode, request)
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(ex: NotFoundException) {
        // NotFoundExceptionがスローされた時、HTTPステータスコード404を返す
        log.error(ex.message, ex)
    }
}