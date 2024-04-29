package br.com.erudio;

import br.com.erudio.exceptions.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static org.apache.tomcat.util.http.parser.HttpParser.isNumeric;

@RestController
public class MathController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{number1}/{number2}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "number1") String num1, @PathVariable(value = "number2") String num2) throws Exception {
        if (!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!!");
        }
        return convertToDouble(num1) + convertToDouble(num2);
    }

    @RequestMapping(value = "/sub/{number1}/{number2}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "number1") String num1, @PathVariable(value = "number2") String num2) throws Exception {
        if (!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!!");
        }
        return convertToDouble(num1) - convertToDouble(num2);
    }

    @RequestMapping(value = "/multi/{number1}/{number2}", method = RequestMethod.GET)
    public Double multi(@PathVariable(value = "number1") String num1, @PathVariable(value = "number2") String num2) throws Exception {
        if (!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!!");
        }
        return convertToDouble(num1) * convertToDouble(num2);
    }

    @RequestMapping(value = "/div/{number1}/{number2}", method = RequestMethod.GET)
    public Double div(@PathVariable(value = "number1") String num1, @PathVariable(value = "number2") String num2) throws Exception {
        if (!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!!");
        }
        return convertToDouble(num1) / convertToDouble(num2);
    }


    @RequestMapping(value = "/media/{number1}/{number2}", method = RequestMethod.GET)
    public Double media(@PathVariable(value = "number1") String num1, @PathVariable(value = "number2") String num2) throws Exception {
        if (!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!!");
        }
        return (convertToDouble(num1) + convertToDouble(num2))/2;
    }

    @RequestMapping(value = "/raiz/{number1}", method = RequestMethod.GET)
    public Double raiz(@PathVariable(value = "number1") String num1) throws Exception {
        if (!isNumeric(num1)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!!");
        }
        return Math.sqrt(convertToDouble(num1));
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
}
