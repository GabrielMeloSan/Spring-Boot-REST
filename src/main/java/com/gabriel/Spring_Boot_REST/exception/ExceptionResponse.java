package com.gabriel.Spring_Boot_REST.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
