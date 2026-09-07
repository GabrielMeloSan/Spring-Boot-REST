package com.gabriel.Spring_Boot_REST.controllers;

import com.gabriel.Spring_Boot_REST.math.SimpleMath;
import com.gabriel.Spring_Boot_REST.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UnknownFormatConversionException;

@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();

    //soma
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value");
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value");
        return math.subtraction(NumberConverter.convertToDouble(numberOne.replace(",", ".")),NumberConverter.convertToDouble(numberTwo.replace(",", ".")));
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws IllegalArgumentException{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnknownFormatConversionException("Please set a numeric value");
        return math.multiplication(NumberConverter.convertToDouble(numberOne.replace(",", ".")),NumberConverter.convertToDouble(numberTwo.replace(",", ".")));
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws IllegalArgumentException{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnknownFormatConversionException("Please set a numeric value");
        return math.division(NumberConverter.convertToDouble(numberOne.replace(",", ".")),NumberConverter.convertToDouble(numberTwo.replace(",", ".")));
    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws IllegalArgumentException{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnknownFormatConversionException("Please set a numeric value");
        return math.mean(NumberConverter.convertToDouble(numberOne.replace(",", ".")),NumberConverter.convertToDouble(numberTwo.replace(",", ".")));
    }

    @RequestMapping("/sqrt/{numberOne}")
    public Double sqrt(
            @PathVariable("numberOne") String numberOne
    )throws IllegalArgumentException{
        if(!NumberConverter.isNumeric(numberOne)) throw new UnknownFormatConversionException("Please set a numeric value");
        return math.sqrt(NumberConverter.convertToDouble(numberOne.replace(",", ".")));

    }


}
