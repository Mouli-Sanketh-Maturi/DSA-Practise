class Solution {
    public int numUniqueEmails(String[] emails) {
        return (int) Arrays.stream(emails).map( email -> convert(email)).distinct().count();
    }

    public static String convert(String email) {
        String[] arr = email.split("@");
        arr[0] = arr[0].replaceAll("\\.","");
        arr[0] = arr[0].split("\\+")[0];
        return arr[0] + "@" + arr[1];
    }
}