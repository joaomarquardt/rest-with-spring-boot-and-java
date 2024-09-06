package com.exemplo.api_gateway;

import com.exemplo.api_gateway.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/math")
public class MathController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/addition/{numberOne}/{numberTwo}")
    public Double addition(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Os valores devem se restringir apenas à números.");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @GetMapping(value = "/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
                              @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Os valores devem se restringir apenas à números.");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @GetMapping(value = "multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Os valores devem se restringir apenas à números.");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @GetMapping(value = "division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Os valores devem se restringir apenas à números.");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @GetMapping(value = "squareroot/{number}")
    public Double squareroot(@PathVariable(value = "number") String number) throws Exception {
        if(!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Os valores devem se restringir apenas à números.");
        }
        return Math.sqrt(convertToDouble(number));
    }


    public Double convertToDouble(String strNumber) {
        String number = strNumber.replaceAll(",", ".");
        return Double.parseDouble(number);
    }

    public boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }


}
