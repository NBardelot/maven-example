package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

public class HashTime {
	String salt = "RandomValue9297247";
	SimpleDateFormat sdf = new SimpleDateFormat("hhssmm");
	
	public String hashTime() {
		return DigestUtils.sha1Hex(salt + sdf.format(new Date()));
	}
}
