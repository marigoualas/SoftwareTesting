package st1920.automaton;

/**
 * Utility class to provide a simple interface to the package.
 */
public class RegExpMatcher {

    public static REstring makeRepeatZeroOrOne(MatchString p) {
        return new REstring(p + "?");
    }

    public static REstring makeRepeatZeroOrMore(MatchString p) {
        return new REstring(p + "*");
    }

    public static REstring makeRepeatOneOrMore(MatchString p) {
        return new REstring(p + "+");
    }

    public static REstring makeOr(MatchString p, MatchString p2) {
        return new REstring(p + "|" + p2);
    }

    public static REstring makeAnd(MatchString p, MatchString p2) {
        return new REstring(p + "&" + p2);
    }

    public static REstring makeFollowedBy(MatchString p, MatchString p2) {
        return new REstring(p + "" + p2);
    }

    public static REstring makeOccurences(MatchString p, MatchString occ) {
        return new REstring(p + "{" + occ + "}");
    }

    public static REstring makeOccurencesAndMore(MatchString p, MatchString occ) {
        return new REstring(p + "{" + occ + ",}");
    }

    public static REstring makeOccurencesFromTo(MatchString p, MatchString occ_from, MatchString occ_to) {
        return new REstring(p + "{" + occ_from + "," + occ_to + "}");
    }

    public static REstring makeNot(MatchString p) {
        return new REstring("~" + p);
    }

    public static REstring makePattern(MatchString p) {
        return new REstring("[" + p + "]");
    }

    public static REstring makeNotPattern(MatchString p) {
        return new REstring("[~" + p + "]");
    }

    public static REstring makeAnyChar() {
        return new REstring(".");
    }
    
    public static MatchString makeDot() {
        return new MatchString(".");
    }

    public static REstring makeNotAnything() {
        return new REstring("#");
    }
    
    public static MatchString makeHash() {
        return new MatchString("#");
    }

    public static REstring makeAnything() {
        return new REstring("@");
    }
    
    public static MatchString makeAt() {
        return new MatchString("@");
    }

    public static REstring makeString(MatchString p) {
        return new REstring("\"" + p + "\"");
    }

    public static REstring makeRange(MatchString num1, MatchString num2) {
        return new REstring("<" + num1 + "-" + num2 + ">");
    }

    public static MatchString makeAlpha() {
        return new MatchString("a");
    }

    public static MatchString makeNum() {
        return new MatchString("1");
    }

    public static MatchString makeB() {
        return new MatchString("b");
    }

    public static MatchString makeC() {
        return  new MatchString("c");
    }

    public static MatchString makeD() {
        return new MatchString("d");
    }

    public static MatchString makeE() {
        return new MatchString("e");
    }

    public static MatchString makeF() {
        return new MatchString("f");
    }

    public static MatchString makeG() {
        return new MatchString("g");
    }

    public static MatchString makeH() {
        return new MatchString("h");
    }

    public static MatchString makeI() {
        return new MatchString("i");
    }

    public static MatchString makeJ() {
        return new MatchString("j");
    }

    public static MatchString makeK() {
        return new MatchString("k");
    }

    public static MatchString makeL() {
        return new MatchString("l");
    }

    public static MatchString makeM() {
        return new MatchString("m");
    }

    public static MatchString makeN() {
        return new MatchString("n");
    }

    public static MatchString makeO() {
        return new MatchString("o");
    }

    public static MatchString makeP() {
        return new MatchString("p");
    }

    public static MatchString makeQ() {
        return new MatchString("q");
    }

    public static MatchString makeR() {
        return new MatchString("r");
    }

    public static MatchString makeS() {
        return new MatchString("s");
    }

    public static MatchString makeT() {
        return new MatchString("t");
    }

    public static MatchString makeU() {
        return new MatchString("u");
    }

    public static MatchString makeV() {
        return new MatchString("v");
    }

    public static MatchString makeW() {
        return new MatchString("w");
    }

    public static MatchString makeX() {
        return new MatchString("x");
    }

    public static MatchString makeY() {
        return new MatchString("y");
    }

    public static MatchString makeZ() {
        return new MatchString("z");
    }

    public static MatchString make1() {
        return new MatchString("1");
    }

    public static MatchString make2() {
        return new MatchString("2");
    }

    public static MatchString make3() {
        return new MatchString("3");
    }

    public static MatchString make4() {
        return new MatchString("4");
    }

    public static MatchString make5() {
        return new MatchString("5");
    }

    public static MatchString make6() {
        return new MatchString("6");
    }

    public static MatchString make7() {
        return new MatchString("7");
    }

    public static MatchString make8() {
        return new MatchString("8");
    }

    public static MatchString make9() {
        return new MatchString("9");
    }

    public static MatchString make0() {
        return new MatchString("0");
    }

    public static MatchString makeOrSymbol() {
        return new MatchString("|");
    }

    public static MatchString makeAndSymbol() {
        return new MatchString("&");
    }

    public static MatchString makeStar() {
        return new MatchString("*");
    }

    public static MatchString makePlus() {
        return new MatchString("+");
    }

    public static MatchString makeConcatenation(MatchString l, MatchString r) {
        return new MatchString(l.getString()+r.getString());
    }

    public static MatchString makeEmpty() {
        return new MatchString("");
    }

    public static boolean matches(MatchString m, REstring re) {
        return matches(m.getString(), re.getString());
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