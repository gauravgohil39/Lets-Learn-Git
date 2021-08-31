public  class Pan_Digital_Roman_Number{

    
    // This is collection of all the char used in Roman Number system
    private String[] check_character = {"I", "V", "X", "L", "C", "D", "M"};


	//Use this class to implement your exercise
	public String checkNumber(int input) {
	    
	    
	      if (number < 2000) {
                if (!(number < 1)) {
                            
                    try {
                    	    // Get ROMAN number in string
                    	   String returnedValueIs = intToRoman(input);
                    	   
                    	   // This method check, is the rouman number has all 7 chars from check_character[] .
                    	   boolean precheck = preValidateAllChar(returnedValueIs);
                    	   
                    	     if (precheck) {
                                     // Check is this String is a "Pandigital Roman Number" or not
                    	            boolean isTrue = isNumber_a_PandigitalRomanNumber(returnedValueIs);
                    	   
                    	             // isTrue is boolean true : number is a "Pandigital Roman Number" then retrun "true"
                    	            if (isTrue)
                    	                return "true";
                    	     }
                    	   
                    	 
                     } catch (Exception exception) {
                             System.out.println("Exception occoured " + exception);
                    }
            
            
            } else
                 System.out.println("Enter a Positive Integer Number");
	          
	      } else
                 System.out.println("Enter a Number less than 2000");
	    
  
	   
	     // isTrue is boolean false : it is not a "Pandigital Roman Number", then return "false"
		return "false";
	}



    
    public String intToRoman(int num) {
        
        // Value ranges from 1000-2000 only,  will get their respective value from thousands array, based on position
        String[] thousands = {"", "M", "MM"};

        // any value of multiple of 100, 100,200,300, ..900 , will get their respective value from hundreds array, based on position
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

        // any value of multiple of 10, 10,20,30, ..90 , will get their respective value from tens array, based on position
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};

        // any value between 1-9 , will get their respective value from units array, based on position
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] + hundreds[(num % 1000) / 100] + tens[(num % 100) / 10] + units[num % 10];
        
        // Divide the number 1446 by 1000 , i will get 1. So thousnad[1] = "M" , 
        // remaining value is now num%1000 = 446 , now divide the number by 100, i will get 4. So  hundreds[4] = "CD"
        // remaining value is now num%100 = 46, now divide the number by 10, i will get 4. so tens[4] = "XL"
        // remaining value is now num%10 = 6, its only single digit. So units[6]="VI"
        //retrun value will be "MCDXLVI" for 1446

    }
    
     public boolean preValidateAllChar(String roman_number) {

        // Checking all the 7 chars of check_character[] present in String roman_number
        for (String s : check_character)
            if (!(roman_number.contains(s)))
                return false;
        
        // if a string roman_number has all the 7 chars of check_character[] then only return true
        return true;
    }


    public boolean isNumber_a_PandigitalRomanNumber(String roman_number) {

        // Using Map interface object , i will store all my roman char, as key and in value i will keep number of count of repetation.
        Map<Character, Integer> baseMap = new HashMap<Character, Integer>();
        char[] charArray = roman_number.toCharArray();
        
        // Use of for loop to add the roman char in key and count in value.
        for (Character ch : charArray) {
            if (baseMap.containsKey(ch)) {
                baseMap.put(ch, baseMap.get(ch) + 1);
            } else {
                baseMap.put(ch, 1);
            }
        }
        
        
        // Once the all vale is been set, now its time to traves the key and count the repetation of element.
        Set<Character> keys = baseMap.keySet();

        for (Character ch : keys) {

            if (baseMap.get(ch) > 1)
                return false;
        }
        
        // if all key has excetly one count then return true or else return false.

        return true;
    }

}