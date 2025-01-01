class Solution {
    public String removeOccurrences(String s, String part) {
    int sLen = s.length();
    int partLen = part.length();
    StringBuilder sb = new StringBuilder();
	
    for(int i = 0; i < sLen; ++i) {
        sb.append(s.charAt(i));
		int startIndexOfPart = sb.length() - partLen;
		
        if(sb.length() >= part.length() &&
          sb.substring(startIndexOfPart, sb.length()).equals(part)) {
		  
            sb.setLength(startIndexOfPart);
        }
    }
    return sb.toString();
}
}