package com.karyasarma.dw_tools_api.exception

import com.karyasarma.dw_tools_api.model.RuntimeExceptionResponse
import com.karyasarma.dw_tools_api.model.ValidationErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException
import javax.validation.ConstraintViolationException

/**
 * @author Daniel Joi Partogi Hutapea
 */
@ControllerAdvice
class GlobalControllerExceptionHandler
{
    @ExceptionHandler(RuntimeException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    fun handleRuntimeException(ex: RuntimeException): RuntimeExceptionResponse
    {
        return RuntimeExceptionResponse(ex.message)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ValidationErrorResponse
    {
        val fieldErrors = ex.bindingResult.fieldErrors
            .map { it.field to it.defaultMessage }
            .toMap()
        return ValidationErrorResponse(fieldErrors)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleConstraintViolationException(ex: ConstraintViolationException): ValidationErrorResponse
    {
        val fieldErrors = ex.constraintViolations
            .map { it.propertyPath.toString() to it.message }
            .toMap()
        return ValidationErrorResponse(fieldErrors)
    }
}
