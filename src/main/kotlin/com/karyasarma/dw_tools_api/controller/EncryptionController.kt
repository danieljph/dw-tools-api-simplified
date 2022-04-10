package com.karyasarma.dw_tools_api.controller

import com.dokupay.utils.JbossDbPasswordUtils
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.NotBlank

/**
 * @author Daniel Joi Partogi Hutapea
 */
@RestController
@RequestMapping("/encryptor")
@Validated
class EncryptionController
{
    companion object {
        const val VALID_AUTHORIZATION = "simple-authorization-2022"
    }

    @GetMapping("/jboss/encrypt")
    @ResponseStatus(HttpStatus.OK)
    fun encryptJbossDb(@Parameter(example = "test1234") @RequestParam @NotBlank plainPassword: String, @RequestParam authorization: String): String
    {
        if(!VALID_AUTHORIZATION.contentEquals(authorization))
        {
            return "Invalid authorization."
        }
        return JbossDbPasswordUtils.encrypt(plainPassword)
    }
}
