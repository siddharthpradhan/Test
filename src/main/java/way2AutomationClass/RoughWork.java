package way2AutomationClass;

import java.io.File;

public class RoughWork {

    static String curDir = System.getProperty("user.dir");
    
    public static void checkFile(String fileName)
    {
    	File files = new File(curDir+fileName);
    	//Path path = Paths.get(curDir+fileName);

    	if (files.exists()) {
    	  System.out.println("File is present..");
    	}

    	else {
    		System.out.println("File is not present..");
    	}
    }
    
	public static void main(String[] args) {
		
		checkFile("09.06.16_careAndroidMobileApp_release_5.0_123.apk");

	}

}
