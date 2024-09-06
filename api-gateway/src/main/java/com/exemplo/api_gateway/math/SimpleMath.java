package com.exemplo.api_gateway.math;

public class SimpleMath {
    public Double addition(Double numberOne, Double numberTwo){
        return (numberOne) + (numberTwo);
    }

    public Double subtraction(Double numberOne, Double numberTwo){
        return (numberOne) - (numberTwo);
    }

    public Double multiplication(Double numberOne, Double numberTwo){
        return (numberOne) * (numberTwo);
    }

    public Double division(Double numberOne, Double numberTwo) {
        return (numberOne) / (numberTwo);
    }

    public Double squareroot(Double number){
        return Math.sqrt(number);
    }

}
