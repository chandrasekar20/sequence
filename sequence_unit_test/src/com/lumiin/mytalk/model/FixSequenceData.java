package com.lumiin.mytalk.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class FixSequenceData implements Serializable, Comparable<FixSequenceData> {


    public int numbers;
    public String code;
    public String message;
    public char type;



    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixSequenceData that = (FixSequenceData) o;
        return numbers == that.numbers &&
                type == that.type &&
                Objects.equals(code, that.code) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, code, message, type);
    }

    @Override
    public int compareTo(FixSequenceData o) {
        int result = 0;
        if (code.compareToIgnoreCase(o.getCode()) == 0) {
            if (numbers == o.getNumbers()) {
                result = 0;
            }
            else if (numbers > o.getNumbers()) {
                result = 1;
            }
            else if (numbers < o.getNumbers()) {
                result = -1;
            }
        }
        else {
            result = code.compareToIgnoreCase(o.getCode());
        }

        return result;
    }

}
