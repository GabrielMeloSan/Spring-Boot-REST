package com.gabriel.Spring_Boot_REST.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UnknownFormatConversionException;

@RestController
@RequestMapping("/math")
public class MathController {

    //soma
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value");
        return convertToDouble(numberOne.replace(",", "."))-convertToDouble(numberTwo.replace(",", "."));
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws IllegalArgumentException{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnknownFormatConversionException("Please set a numeric value");
        return convertToDouble(numberOne.replace(",", "."))*convertToDouble(numberTwo.replace(",", "."));
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws IllegalArgumentException{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnknownFormatConversionException("Please set a numeric value");
        return convertToDouble(numberOne.replace(",", "."))/convertToDouble(numberTwo.replace(",", "."));
    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws IllegalArgumentException{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnknownFormatConversionException("Please set a numeric value");
        return (convertToDouble(numberOne.replace(",", "."))+convertToDouble(numberTwo.replace(",", ".")))/2;
    }

    @RequestMapping("/sqrt/{numberOne}")
    public Double sqrt(
            @PathVariable("numberOne") String numberOne
    )throws IllegalArgumentException{
        if(!isNumeric(numberOne)) throw new UnknownFormatConversionException("Please set a numeric value");
        return Math.sqrt((convertToDouble(numberOne.replace(",", "."))));

    }

    private Double convertToDouble(String strnumber) throws IllegalArgumentException{
        if (strnumber == null || strnumber.isEmpty()) throw new UnsupportedOperationException("Please set a numeric value");
        String number =  strnumber.replace(",", ".");

        return Double.parseDouble(strnumber);
    }

    private boolean isNumeric (String strnumber){
        if (strnumber == null || strnumber.isEmpty()) return false;
        String number =  strnumber.replace(",", ".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }
}
