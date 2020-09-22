package Str;
/**
 * @author Hongliang Zhu
 * @create 2020-09-22 14:07
 *
 * leetcode 468 验证ip地址
 */
public class leetcode468_ValidIPAddress {

    public String validIPAddress(String IP) {

        if(IP == null || "".equals(IP)){
            return "Neither";
        }
        String[] split  = null;
        if(IP.contains(".")){

            if(isNumber(IP.charAt(IP.length() - 1)) ){
                split = IP.split("\\.");
            }else {
                return "Neither";
            }
        }else{
            if(isNumber(IP.charAt(IP.length() - 1)) || isLetter(IP.charAt(IP.length() - 1))){
                split = IP.split(":");
            }else {
                return "Neither";
            }

        }
        if(split.length == 4){
            if(validIpV4(split)){
                return "IPv4";
            }else{
                return "Neither";
            }

        }else if(split.length == 8){

            if(validIpV6(split)){
                return "IPv6";
            }else{
                return "Neither";
            }

        }else {
            return "Neither";
        }

    }

    private boolean validIpV4(String[] s){
        for(String str: s){
            if(str.length() > 1  && str.charAt(0) == '0'){
                return false;
            }
            try {
                int num = Integer.parseInt(str);
                if( num >= 0 && num <= 255 ){
                    continue;
                }else{
                    return false;
                }
            }catch (NumberFormatException e) {
                return false;
            }

        }
        return true;
    }

    private boolean validIpV6(String[] s){
        for(String str: s){
            if(str == null || "".equals(str) || str.length() > 4){
                return false;
            }
            for (int i = 0; i < str.length(); i++){
                if(isLetter(str.charAt(i)) || isNumber(str.charAt(i))){
                    continue;
                }else{
                    return false;
                }
            }

        }
        return true;
    }

    private boolean isLetter(char c){
        if (( c >= 'a' && c <= 'f') || ( c >= 'A' && c <= 'F' )){
            return true;
        }else
        {
            return  false;
        }
    }
    private boolean isNumber(char c){
        if( c >= '0' && c <= '9'){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args) {
        leetcode468_ValidIPAddress solution = new leetcode468_ValidIPAddress();
        System.out.println(solution.validIPAddress("172.16.254.1"));
        System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(solution.validIPAddress("256.256.256.256"));
        System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(solution.validIPAddress("1e1.4.5.6"));
        System.out.println(solution.validIPAddress("1.1.1.1"));
        System.out.println(solution.validIPAddress("1.1.1.1."));
        System.out.println(solution.validIPAddress("f:f:f:f:f:f:f:f"));
        System.out.println(solution.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
//
//        String s= "192.168.120.20";
//        System.out.println(s.contains("."));

    }

}
