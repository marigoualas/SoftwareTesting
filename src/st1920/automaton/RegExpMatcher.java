package st1920.automaton;

/**
 * Utility class to provide a simple interface to the package.
 */
public class RegExpMatcher {

    public static MatchString makeRepeatZeroOrOne(MatchString p) {
        return new MatchString(p + "?");
    }

    public static MatchString makeRepeatZeroOrMore(MatchString p) {
        return new MatchString(p + "*");
    }

    public static MatchString makeRepeatOneOrMore(MatchString p) {
        return new MatchString(p + "+");
    }

    public static MatchString makeOr(MatchString p, MatchString p2) {
        return new MatchString(p + "|" + p2);
    }

    public static MatchString makeAnd(MatchString p, MatchString p2) {
        return new MatchString(p + "&" + p2);
    }

    public static MatchString makeFollowedBy(MatchString p, MatchString p2) {
        return new MatchString(p + "" + p2);
    }

    public static MatchString makeOccurences(MatchString p, MatchString occ) {
        return new MatchString(p + "{" + occ + "}");
    }

    public static MatchString makeOccurencesAndMore(MatchString p, MatchString occ) {
        return new MatchString(p + "{" + occ + ",}");
    }

    public static MatchString makeOccurencesFromTo(MatchString p, MatchString occ_from, MatchString occ_to) {
        return new MatchString(p + "{" + occ_from + "," + occ_to + "}");
    }

    public static MatchString makeNot(MatchString p) {
        return new MatchString("~" + p);
    }

    public static MatchString makePattern(MatchString p) {
        return new MatchString("[" + p + "]");
    }

    public static MatchString makeNotPattern(MatchString p) {
        return new MatchString("[~" + p + "]");
    }

    public static MatchString makeAnyChar() {
        return new MatchString(".");
    }

    public static MatchString makeNotAnything() {
        return new MatchString("#");
    }

    public static MatchString makeAnything() {
        return new MatchString("@");
    }

    public static MatchString makeString(MatchString p) {
        return new MatchString("\"" + p + "\"");
    }

    public static MatchString makeRange(MatchString num1, MatchString num2) {
        return new MatchString("<" + num1 + "-" + num2 + ">");
    }

    public static String makeAlpha() {
        return "a";
    }

    public static String makeNum() {
        return "1";
    }
    
    public static String makeOrSymbol() {
        return "|";
    }
    
    public static String makeAndSymbol() {
        return "&";
    }
    
    public static String makeStar() {
        return "*";
    }
    
    public static String makePlus() {
        return "+";
    }

    public static String makeConcatenation(String l, String r) {
        return l + r;
    }

    public static boolean matches(String m, MatchString re) {
        return matches(m, re.getString());
    }

    /**
     * Tells whether the string <code>m</code> matches the regular expression
     * <code>re</code>.
     * 
     * @param m
     *            string to be matched
     * @param re
     *            regular expression
     */
    public static boolean matches(String m, String re) {
        RegExp regExp = new RegExp(re);
        Automaton a = regExp.toAutomaton();
        return a.run(m);
    }
}