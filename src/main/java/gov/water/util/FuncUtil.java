package gov.water.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class FuncUtil {
	
	public String requestParameters(HttpServletRequest request){
		String retval = "";
		
		Enumeration<String> em = request.getParameterNames();
		while (em.hasMoreElements()) {
		    String name = (String) em.nextElement();
		    String value = request.getParameter(name);
		    
		    if( retval.equals("") ){
				retval = "?" + name + "=" + value;
			}else{
				retval += "&" + name + "=" + value;
			}
		}
		
		return retval;
	}
}
