package application;

public class Calculations {
	
	
	public String calculateNum(int num1, int num2, String operator) {
        // Convert num1 and num2 to 8-bit binary numbers
        String binary1 = decimalToBinary(num1);
        String binary2 = decimalToBinary(num2);
        
        // Convert negative numbers to 2's complement form
        if (num1 < 0) {
            binary1 = twosComplement(binary1);
        }
        if (num2 < 0) {
            binary2 = twosComplement(binary2);
        }
        
        // Perform the operation
        String result = "";
        boolean overflow = false;
        switch (operator) {
            case "Addition":
                // Add binary1 and binary2
                int carry = 0;
                for (int i = binary1.length() - 1; i >= 0; i--) {
                    int sum = carry + (binary1.charAt(i) - '0') + (binary2.charAt(i) - '0');
                    if (sum > 1) {
                        carry = 1;
                        result = (sum % 2) + result;
                    } else {
                        carry = 0;
                        result = sum + result;
                    }
                }
                if (carry == 1) {
                    overflow = true;
                }
                break;
            case "Subtraction":
                // Subtract binary2 from binary1
                String negBinary2 = twosComplement(binary2);
                carry = 0;
                for (int i = binary1.length() - 1; i >= 0; i--) {
                    int diff = (binary1.charAt(i) - '0') - (negBinary2.charAt(i) - '0') - carry;
                    if (diff < 0) {
                        carry = 1;
                        result = (diff + 2) + result;
                    } else {
                        carry = 0;
                        result = diff + result;
                    }
                }
                if (carry == 1) {
                    overflow = true;
                }
                break;
            case "Comparison":

            	 // Compare binary1 and binary2
                if (binary1.equals(binary2)) {
                    result = "Equal";
                } else {
                    result = "Not equal";
                }
                break;
            default:
                return "Invalid operator";
        }
        
        // return values
        if (overflow) {
            return "Overflow";
        } else {
            return result;
        }
    }

    public String decimalToBinary(int num) {
    	if (Math.abs(num) > 255)
    		throw new IndexOutOfBoundsException();
    	
    	String binary = Integer.toBinaryString(Math.abs(num));
        // Pad with leading zeroes if necessary
        while (binary.length() < 8) {
            binary = "0" + binary;
        }
        
        return binary;
    }
    
    // Method to convert a binary number to its 2's complement form
    public String twosComplement(String binary) {
        // Invert all the bits
        String inverted = "";
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                inverted += '1';
            } else {
                inverted += '0';
            }
        }
        // Add 1 to the inverted number
        String twosComplement = "";
        boolean carry = true;
        for (int i = inverted.length() - 1; i >= 0; i--) {
            if (inverted.charAt(i) == '0' && carry) {
                twosComplement = "1" + twosComplement;
                carry = false;
            } else if (inverted.charAt(i) == '1' && carry) {
                twosComplement = "0" + twosComplement;
            } else {
                twosComplement = inverted.charAt(i) + twosComplement;
            }
        }
        return twosComplement;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
