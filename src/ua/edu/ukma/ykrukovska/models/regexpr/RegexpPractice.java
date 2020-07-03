package ua.edu.ukma.ykrukovska.models.regexpr;

public class RegexpPractice {

    private static String id = "[A-Za-z]\\w*";

    public static void main(String[] args) {
        System.out.println(onlyOdd("aaabbb"));
        System.out.println(onlyOdd("bbaa"));
        System.out.println(onlyOdd("baabba"));

        System.out.println(isIden("2aa2378_23"));
        System.out.println(isIden("aa2378_23"));
        System.out.println(isIden("2a,a23"));

        System.out.println("Amount of id " + cntIden("a_2323ajsd a2323 a4hkn"));
        System.out.println("Amount of id " + cntIden("2_2323ajsd a2323 a4hkn aa_2 23253 ashb a,,"));

        System.out.println(distIden("a22 2aa a2a5w 666 88jn a22 a22"));

        System.out.println(sumDouble("23.5    ,+233.2,-52323.0"));
        System.out.println(sumDouble("23.5sdfff +233.2,-52323.0"));
        System.out.println(sumDouble("__23,, +233.2,-52323.0"));
        System.out.println(sumDouble("5.0, +10.5,-3.25"));

    }

    public static boolean onlyOdd(String str) {

        return str.matches("(b*ab*(ab*ab*)*|a*ba*(ba*ba*)*)");
    }

    public static boolean isIden(String str) {
        return str.matches(id);
    }

    public static int cntIden(String str) {

        String[] split = str.split("\\s");

        int result = 0;
        if (split.length > 0) {
            for (int i = 0; i < split.length; i++) {
                if (split[i].matches(id)) {
                    result++;
                }
            }
        }
        return result;

    }

    public static int distIden(String str) {

        String[] split = str.split("\\s");
        int amountOfId = cntIden(str);
        int length = split.length;


        if (length > 0) {

            for (int i = 0; i < length; i++) {
                if (!split[i].matches(id)) {
                    split[i] = null;
                    for (int j = i + 1; j < length; j++) {
                        split[j - 1] = split[j];

                    }
                    split[--length] = null;
                }
            }

            for (int i = 0; i < length; i++) {
                for (int k = i + 1; k < length; k++) {
                    if (split[i] != null && split[k] != null) {
                        if (split[i].equals(split[k])) {
                            amountOfId--;
                            split[k] = null;
                            for (int j = k + 1; j < length; j++) {
                                split[j - 1] = split[j];
                            }
                            split[length] = "";
                        }
                    }
                }
            }
        }
        return amountOfId;
    }

    public static Double sumDouble(String str) {

        String regex = "\\s*[+-]?[\\d]+[.][\\d]+\\s*";
        String[] numbers = str.split(",");


        for (int i = 0; i < numbers.length; i++) {
            if (!numbers[i].matches(regex)) {
                return null;
            }
        }

        double result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += Double.parseDouble(numbers[i]);
        }

        return result;
    }

}
