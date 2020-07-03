package ua.edu.ukma.ykrukovska.models.regexpr;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Algorithm {

    private String desc;
    private ArrayList<Rule> base;

    public Algorithm(String desc) {
        this.desc = desc;
    }

    class Rule {
        Pattern left;
        String right;
        boolean end;
    }

    private String eval(String input, int cnt) {
        return "undefined";
    }

    private boolean isGood() {
        if (base != null) {
            return true;
        }
        return false;
    }
}

