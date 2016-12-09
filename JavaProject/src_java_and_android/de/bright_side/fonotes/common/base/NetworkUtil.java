package de.bright_side.fonotes.common.base;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class NetworkUtil {
	public enum IPAddressType{IPV4, IPV6, ANY}
	
	
	public static List<String> getAllTokens(String string, char delimiter){
		List<String> returnList = new ArrayList<String>();
		if ((string == null) || (string.length() == 0)) return returnList; 
		StringTokenizer st = new StringTokenizer(string, "" + delimiter);
		while(st.hasMoreTokens()){
			returnList.add(st.nextToken());
		}
		return returnList;
	}

	/**
     * Get IP addresses without localhost 
     */
	public static List<String> getIPAddresses(IPAddressType addressType, boolean allowNonLoopBack, boolean allowLoopBack) {
    	List<String> result = new ArrayList<String>();
		try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                	boolean match = false;
                	if (allowLoopBack && addr.isLoopbackAddress()){
                		match = true;
                	}
                	if (allowNonLoopBack && !addr.isLoopbackAddress()){
                		match = true;
                	}
                	
                    if (match) {
                        String sAddr = addr.getHostAddress().toUpperCase();
                        boolean isIPv4 = isIPv4Address(sAddr); 
                        if (matches(isIPv4, addressType)){
                            if (!isIPv4) {
                                int delim = sAddr.indexOf('%'); // find ip6 port suffix
                                if (delim >= 0){
                                	sAddr = sAddr.substring(0, delim);
                                }
                            }
                            result.add(sAddr);
                        }
                    }
                }
            }
        } catch (Exception ignored) { } 
        return result;
	}

	/**
     * Get IP addresses without localhost 
     */
	public static List<NetworkUtilIPAddressInfo> getIPAddressInfos(IPAddressType addressType, boolean allowNonLoopBack, boolean allowLoopBack) {
    	List<NetworkUtilIPAddressInfo> result = new ArrayList<NetworkUtilIPAddressInfo>();
		try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                	boolean match = false;
                	if (allowLoopBack && addr.isLoopbackAddress()){
                		match = true;
                	}
                	if (allowNonLoopBack && !addr.isLoopbackAddress()){
                		match = true;
                	}
                	
                    if (match) {
                        String sAddr = addr.getHostAddress().toUpperCase();
                        boolean isIPv4 = isIPv4Address(sAddr); 
                        if (matches(isIPv4, addressType)){
                            if (!isIPv4) {
                                int delim = sAddr.indexOf('%'); // find ip6 port suffix
                                if (delim >= 0){
                                	sAddr = sAddr.substring(0, delim);
                                }
                            }
                            
                            NetworkUtilIPAddressInfo item = new NetworkUtilIPAddressInfo();
                            item.setAddress(sAddr);
                            item.setDisplayName(intf.getDisplayName());
                            item.setV4(isIPv4);
                            item.setVirtual(intf.isVirtual());
                            item.setPointToPoint(intf.isPointToPoint());
                            result.add(item);
                        }
                    }
                }
            }
        } catch (Exception ignored) { } 
        return result;
	}

	
	private static boolean matches(boolean isIPv4, IPAddressType addressType) {
		if (addressType == IPAddressType.ANY){
			return true;
		}
		if ((isIPv4) && (addressType == IPAddressType.IPV4)){
			return true;
		}
		if ((!isIPv4) && (addressType == IPAddressType.IPV6)){
			return true;
		}
		return false;
	}

	public static boolean isIPv4Address(String address) {
		if (address.contains(":")){
			return false;
		}
		String parseAddress = address.replace(".", ":"); 
		int items = 0;
		for (String i: parseAddress.split(":")){
			try{
				int part = Integer.valueOf(i);
				if ((part < 0) || (part > 255)){
					return false;
				}
			} catch (NumberFormatException e){
				return false;
			}
			items ++;
		}
		return items == 4;
	}
	
}
