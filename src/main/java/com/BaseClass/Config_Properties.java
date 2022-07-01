package com.BaseClass;

public class Config_Properties implements IAutoConsts{

	protected static String US_URL;
	protected static String UK_URL;
	protected static String USER_ID;
	protected static String PASSWORD;
	protected static String AU_URL;
	protected static String REG_US_URL;
	protected static String REG_UK_URL;
	protected static String REG_AU_URL;
	protected static String MYS_OVERVEW;
	protected static String MYS_ACTIVE;
	protected static String MYS_UNSOLD;
	protected static String MYS_SOLD;
	
	
	public static void loadConfigValues() throws Throwable {
		
		 USER_ID = new FileLib().readProprertyData(Prop_Path, "id");
		 PASSWORD = new FileLib().readProprertyData(Prop_Path, "password");
		 US_URL = new FileLib().readProprertyData(Prop_Path, "us_url");
		 UK_URL = new FileLib().readProprertyData(Prop_Path, "uk_url");
		 AU_URL = new FileLib().readProprertyData(Prop_Path, "au_url");
		 REG_US_URL = new FileLib().readProprertyData(Prop_Path, "reg_us_url");
		 REG_UK_URL = new FileLib().readProprertyData(Prop_Path, "reg_uk_url");
		 REG_AU_URL = new FileLib().readProprertyData(Prop_Path, "reg_au_url");
		 MYS_OVERVEW = new FileLib().readProprertyData(Prop_Path, "mys_overview");
		 MYS_ACTIVE =new FileLib().readProprertyData(Prop_Path, "mys_active");
		 MYS_UNSOLD =new FileLib().readProprertyData(Prop_Path, "mys_unsold");
		 MYS_SOLD =new FileLib().readProprertyData(Prop_Path, "mys_sold");
	}
}
