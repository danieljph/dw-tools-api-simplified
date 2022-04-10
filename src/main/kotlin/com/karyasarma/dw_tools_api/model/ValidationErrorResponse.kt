package com.karyasarma.dw_tools_api.model

/**
 * @author Daniel Joi Partogi Hutapea
 */
data class ValidationErrorResponse(
    var fieldErrors: Map<String, String?>
)
