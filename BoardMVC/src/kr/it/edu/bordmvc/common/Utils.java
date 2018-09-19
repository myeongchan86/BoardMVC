package kr.it.edu.bordmvc.common;

public class Utils {

	public static int getParamInt(String p) {
		int r = 0;

		if (p != null && !p.equals("")) {
			try {
				r = Integer.parseInt(p);
			} catch (Exception e) {
			}
		}
		return r;
	}
}
