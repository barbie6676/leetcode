/*12*/


public String intToRoman(int num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        char[] letter = {'I','V','X','L','C','D','M'};
        
        String roman = "";
        int i = 0;
        while (num>0) {
            int d = num%10;
            
			char u1 = letter[i*2];
			if (i <3) {
			    if (d<=3){
					for (int k = 0; k <d;k++){
						roman= u1 + roman;
					}
				} else {
					char u2 = letter[i*2+1];
					if (d == 4) {
						roman = u2 + roman;
						roman = u1 + roman; 
					} else if (d>=5&&d<=8) {
						for ( int k = 0; k < d-5; k++) {
							roman = u1 + roman;
						}
						roman = u2 + roman;
					} else {
					   char u3 = letter[i*2+2];
					   roman = u3 + roman;
					   roman = u1 + roman;
					} 
					
				}
			
				
			} else {
				for (int k = 0; k <d;k++){
					roman= u1 + roman;
				}
			}
                
            num/= 10;
            i++;
        }
        return roman;
        
    }
