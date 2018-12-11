
public class HAZCHEM {
	private String code;
	
	public HAZCHEM(String code)
	{
		this.code = code;
	}
	
	public String getMaterial()
	{
		String Material;
		switch(code.charAt(0))
		{
		case '1': Material = "jets";
			break;
		case '2': Material = "fog";
			break;
		case '3': Material = "foam";
			break;
		case '4': Material = "dry agent";
			break;
		default: Material = "N/A";
		}
		return Material;
	}
	
	public String getReaction()
	{
		String Reaction;
		switch(code.charAt(1))
		{
		case 'P':
		case 'S':
		case 'W':
		case 'Y': Reaction = "violent reaction may occur";
			break;
		case 'R':
		case 'T':
		case 'X':
		case 'Z': Reaction = "no reaction";
		 break;
		default: Reaction = "N/A";
		}
		return Reaction;
	}

	public String getProtection()
	{
		String Protection;
		switch(code.charAt(1))
		{
		case 'P':
		case 'R':
		case 'W':
		case 'X': Protection = "protective clothing and breathing apparatus required";
			break;
		case 'S':
		case 'T':
		case 'Y':
		case 'Z': Protection= "breathing apparatus required";
		 break;
		default: Protection = "N/A";
		}
		return Protection;
   }


	public String getContainment()
	{
		String Containment;
		switch(code.charAt(1))
		{
		case 'P':
		case 'R':
		case 'S':
		case 'T': Containment = "dilute with water and wash down the drain";
			break;
		case 'W':
		case 'X':
		case 'Y':
		case 'Z': Containment = "contain and prevent from entering any water course";
		 break;
		default: Containment = "N/A";
		}
		return Containment;
   }

   public String getEvacuation()
   {
      if( (code.length() == 3) && (code.charAt(2) == 'E') )
      {
         return "consider evacuation";
      }else
      {
         return "No evacuation necessary";
      }
   }

   public String getAdvice()
   {
      String advice =   "***Emergency action advice***"  +  "\n"
                     +  "Material:\t"     +  getMaterial()     +  "\n"
                     +  "Reaction:\t"     +  getReaction()     +  "\n"
                     +  "Protection:\t"   +  getProtection()   +  "\n"
                     +  "Containment:\t"  +  getContainment()  +  "\n"
                     +  "Evacuation:\t"   +  getEvacuation()   +  "\n"
                     +  "*****************************"        +  "\n";
      return advice;
   }

   public String toString()
   {
      return getClass().getName() + "[\ncode: " + code + "\n]";
   }
}
