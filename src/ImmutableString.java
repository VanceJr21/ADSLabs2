public class ImmutableString {
    public static void main(String[] args) {
        String myString = new String("old String");
        String myCache = myString;
        System.out.println(myString.equals(myCache));
        System.out.println((myString == myCache));
    }
}
